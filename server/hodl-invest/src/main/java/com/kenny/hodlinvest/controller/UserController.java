package com.kenny.hodlinvest.controller;

import com.kenny.hodlinvest.exception.UserException;
import com.kenny.hodlinvest.exception.UserNotFoundException;
import com.kenny.hodlinvest.model.Cryptocoin;
import com.kenny.hodlinvest.model.Token;
import com.kenny.hodlinvest.model.Transaction;
import com.kenny.hodlinvest.model.User;
import com.kenny.hodlinvest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final Map<String, Token> tokenMap = new HashMap<>();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin()
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @CrossOrigin()
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{username}"
    )
    public User getUserByName(@PathVariable String username){
        if(!userService.userExists(username))
            throw new UserNotFoundException("User does not exist");

            return userService.getUserByName(username);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void addNewUser(@RequestBody User user){
        if(userService.userExists(user.getUsername())){
            throw new UserException("Username already exists.");
        }
        userService.addUser(user.getUsername(), user);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{username}"
    )
    public void deleteUserByName(@PathVariable String username){
        if(!userService.userExists(username))
            throw new UserNotFoundException("User does not exist");

        userService.deleteUserByName(username);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "{username}/transactions/{amount}"
    )
    public void updateUserPlayMoney(@PathVariable String username, @PathVariable double amount){
        if(!userService.userExists(username))
            throw new UserNotFoundException("User does not exist");

        userService.updateUserPlayMoney(username, amount);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "{username}/transactions",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void addTransaction(@RequestBody Cryptocoin cryptocoin, @PathVariable("username") String username){
        if(!userService.userExists(username))
            throw new UserNotFoundException("User does not exist");

        System.out.println("Added transaction: " + cryptocoin.getTicker() + " with price: " + cryptocoin.getPrice() + " to user: " + username);
        userService.addTransaction(username, cryptocoin.getTicker(), cryptocoin.getPrice());
    }

    @CrossOrigin()
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{username}/transactions"
    )
    public List<Transaction> getUserTransactions(@PathVariable String username){
        if(!userService.userExists(username))
            throw new UserNotFoundException("User does not exist");

        return userService.getUserTransactions(username);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "login"
    )
    public Token userLogin(@RequestBody Map<String, String> userInfo){
        String username = userInfo.get("username");
        String password = userInfo.get("password");

        System.out.println("Attempting to login user " + username + " password " + password);
        if(!userService.userExists(username))
            throw new UserNotFoundException("User does not exist");

        if(tokenMap.get(username) != null)
            throw new UserException("User already logged in.");

        if(userService.authenticateUser(username, password)){
            Token token = new Token(null, username);
            tokenMap.put(token.getToken(), token);
            return token;
        } else{
            throw new UserException("Failed to authenticate user. Either username or password is incorrect or null.");
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "logout"
    )
    public void userLogout(@RequestBody Map<String, String> tokenJson){
        String token = tokenJson.get("token");
        System.out.println("token is " + token);
        Token curToken = tokenMap.get(token);
        if(curToken == null)
            throw new UserException("Invalid token to logout.");
        else{
            tokenMap.remove(token);
            System.out.println("Successfully logged out user " + curToken.getUsername());
        }
    }
}
