# hodl-invest
**hodl-invest server API documentation**
https://hodl-invest-server.herokuapp.com/
----

* **https://hodl-invest-server.herokuapp.com/api/v1/users/**


* **Method:**
  

  `GET`  
*  **URL Params**

   **Required:** N/A
 

   **Optional:** N/A
   
 * **Sample Call:**

 ```
 var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
  if (this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("GET", "https://hodl-invest-server.herokuapp.com/api/v1/users/");
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("cache-control", "no-cache");

xhr.send(data);
 ```

* **Method:**

  `POST`
  
*  **URL Params**

   **Required:**
 
   `username=[string]`
   `passwordHash=[string]`
   `name=[string]`
   `email=[string]`
   `playMoney=[integer]`

   **Optional:**


* **Sample Call:**
```
var data = JSON.stringify({
  "username": "bobthebuilder",
  "passwordHash": "fakepassword",
  "name": "johnny",
  "email": "johnny@email.com",
  "playMoney": 2000,
  "transactions": []
});

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
  if (this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("POST", "https://hodl-invest-server.herokuapp.com/api/v1/users/");
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("cache-control", "no-cache");

xhr.send(data);
```  
* **https://hodl-invest-server.herokuapp.com/api/v1/users/{username}**

* **Method:**
  `GET`
  `DELETE`
  
*  **URL Params**
  {username} (string)

   **Optional:**


* **Sample Call:**

```
var data = JSON.stringify({
  "username": "zoro1",
  "name": "bobby",
  "email": "testemail@email.com",
  "playMoney": 1500
});

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
  if (this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("GET", "https://hodl-invest-server.herokuapp.com/api/v1/users/ninja");
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("cache-control", "no-cache");

xhr.send(data);
```


```
var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
  if (this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("DELETE", "https://hodl-invest-server.herokuapp.com/api/v1/users/ninja");
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("cache-control", "no-cache");

xhr.send(data);
```

  
* **https://hodl-invest-server.herokuapp.com/api/v1/users/{username}/transactions/{amount}**


* **Method:**

  `POST`
  
*  **URL Params**
 {username}   {string}
 {amount}     {double}
   **Required:** N/A

   **Optional:** N/A
 
* **https://hodl-invest-server.herokuapp.com/api/v1/users/zoro/transactions**

* **Method:**
  
  `GET`
  
*  **URL Params**

   **Required:**

   **Optional:**

    **Returns JSON**
    ```
     [
    {
        "cryptocoin": {
            "ticker": "btc",
            "price": 6543
        },
        "timestamp": "2018-03-28T04:28:13.756"
    },
    {
        "cryptocoin": {
            "ticker": "eth",
            "price": 525
        },
        "timestamp": "2018-03-28T04:28:13.756"
    }
]
    ```
* **Notes:**

* **Method:**
  
  `POST`
  
*  **URL Params**

   **Required:**

   **Optional:**
   
* **Sample Call:**

```
var data = JSON.stringify({
  "ticker": "abc",
  "price": 22
});

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
  if (this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("POST", "https://hodl-invest-server.herokuapp.com/api/v1/users/zoro/transactions");
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("cache-control", "no-cache");

xhr.send(data);
```

* **Notes:**

[![Gitter chat](https://badges.gitter.im/MutualFund/Lobby.png)](https://gitter.im/MutualFund/Lobby)
