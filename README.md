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
 

* **Method:**
  

  `POST`
  
*  **URL Params**

   **Required:**
 
   `username=[string]`
   `password=[string]`
   `name=[string]`
   `email=[string]`
   `playMoney=[integer]`

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

xhr.open("POST", "https://hodl-invest-server.herokuapp.com/api/v1/users/");
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("cache-control", "no-cache");
xhr.setRequestHeader("postman-token", "892b1a54-83a8-7bf4-082c-6dce55be2147");

xhr.send(data);
```  
  
* **https://hodl-invest-server.herokuapp.com/api/v1/users/{username}/transactions/{amount}**


* **Method:**

  `POST`
  
*  **URL Params**

   **Required:** N/A
 

   **Optional:** N/A
 

* **Method:**
  

  `POST`
  
*  **URL Params**

   **Required:**
 
   `username=[string]`
   `playMoney=[integer]`

   **Optional:**

* **Notes:**


[![Gitter chat](https://badges.gitter.im/MutualFund/Lobby.png)](https://gitter.im/MutualFund/Lobby)
