# Automate API testing using RestAssured(Maven_Selenium)
## Scope 
### 1. Login user and get token.
Base URL: ```https://dummyjson.com/```
Endpoint: ```/auth/login```
HTTP request: ```POST```
Request body:  ```{
  username: 'emilys',
  password: 'emilyspass',
  expiresInMins: 30, // optional, defaults to 60```
### 2. Get current auth user.
Base URL: ```https://dummyjson.com/```
Endpoint: ```/auth/me```
HTTP request ```GET```
headers: ```'Authorization': 'Bearer /* YOUR_TOKEN_HERE */'```

### 3. Refresh auth session.
Base URL: ```https://dummyjson.com/```
Endpoint: ```auth/refresh```
HTTP request: ```POST```
Request body: ```
  refreshToken: '/* YOUR_REFRESH_TOKEN_HERE */',
  expiresInMins: 30, // optional, defaults to 60```

### 4. Get all products.
Base URL: ```https://dummyjson.com/```
Endpoint: ```/products```
HTTP request: ```GET```

### 5. Get a single product.
Base URL: ```https://dummyjson.com/```
Endpoint: ```/products/1```
HTTP request: ```GET```

### 6. Search products.
Base URL: ```https://dummyjson.com/```
Endpoint: ```/api/v1/transaction_fee```
HTTP request: ```POST```
Request body  ```{
  "amount": 2.5,
  "currency": "BTC",
  "recipient_address": "0x1234567890ABCDEF"}```

### 7. Limit and skip products. 
Base URL: ```https://dummyjson.com/```
Endpoint: ```products?limit=10&skip=10&select=title,price```
HTTP request: ```GET```

### 8. Sort products. 
Base URL: ```https://dummyjson.com/```
Endpoint: ```/products?sortBy=title&order=asc```
HTTP request: ```GET```

### 9. Get all products categories. 
Base URL: ```https://dummyjson.com/```
Endpoint: ```/products/categories```
HTTP request: ```GET```

### 10. Get products category list. 
Base URL: ```https://dummyjson.com/```
Endpoint: ```products/category-listc```
HTTP request: ```GET```

### 11. Get products by a category. 
Base URL: ```https://dummyjson.com/```
Endpoint: ```/products/category/smartphones```
HTTP request: ```GET```

### 12. Add a new product. 
Base URL: ```https://dummyjson.com/```
Endpoint: ```products/add```
HTTP request: ```POST```
Request body: ```
   title: 'BMW Pencil',
   /* other product data */```

### 13. Update a product. 
Base URL: ```https://dummyjson.com/```
Endpoint: ```/products/1```
HTTP request: ```POST```
Request body: ```
  title: 'iPhone Galaxy +1'```

### 14. Delete a product. 
Base URL: ```https://dummyjson.com/```
Endpoint: ```/products/1```
HTTP request: ```DELETE```
## Test Result
### Code: 

![image](https://github.com/user-attachments/assets/fe27380d-2bd7-4b42-881b-a648a9875a93)


### Output:

![image](https://github.com/user-attachments/assets/802b8126-af2a-4365-90f9-77e4dfe2aa3f)

## Project Structure & Code Structure
I use Maven Project and Java for writting test script

Here are the referance links for how to setup your project - 
### 1. Download IDE [SprinTool](https://spring.io/tools) or [Eclipse](https://www.eclipse.org/downloads/)
### 2. Create a [Maven Projrct](https://medium.com/@leninstalinesec/benefits-of-maven-for-java-developers-8083f9d33665#:~:text=Maven%20project%20enforces%20a%20standard,src%2Fmain%2Ftest%20folder.).
### 3. Add requered [Maven dependencies](https://mvnrepository.com/) in to your  ```pom.xml``` file.
#### Example:

![image](https://github.com/user-attachments/assets/5436f1a1-a324-4740-ba75-02008cff98a4)

## Getting started
1. Install [git](https://www.git-scm.com/) , [node.js](https://nodejs.org/en) & [Maven](https://maven.apache.org/download.cgi) in your system.
2. Open your terminal
Paste this command
```bash
git clone https://github.com/janasagar/Republic-REST_074_Restassuerd.git
```
3. Open this project in your IDE
4. Oepn your terminal in your IDE and run this commad ```mvn test```


Thanks:)

