package apitesting_restassured;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Testsuite {
    String burl = "https://dummyjson.com"; // Base URL
    String token; // Variable to store the token
    
    @Test
    public void Auth() {
        // Creating JSON request body for authentication
        JSONObject req_body = new JSONObject();
        req_body.put("username", "michaelw");
        req_body.put("password", "michaelwpass");

        // Sending POST request to authenticate and get the token
        Response response = given()
            .header("Content-Type", "application/json")
            .body(req_body.toJSONString())
            .when()
            .post(burl + "/auth/login")
            .then()
            .statusCode(200)
            .log().all()
            .extract().response();
        
        // Extract token from the response
        token = response.jsonPath().getString("token");
        System.out.println("Token is: " + token);
    }
	
	@Test(dependsOnMethods = "Auth")
	public void Get_current_user() {
		// Sending GET request to fetch the current user details
		given()
        .header("Authorization", "Bearer " + token)
        .when()
        .get(burl + "/auth/me")
        .then()
        .statusCode(200)
        .log().all();
	}

	@Test(dependsOnMethods = "Auth")
	public void refreshAuthToken() {
		// Creating JSON request body to refresh the token
		JSONObject req_body = new JSONObject();
		req_body.put("refreshToken", token);
		// req_body.put("expiresInMins", 30); // optional, defaults to 60

		// Sending POST request to refresh the token
		Response response = given()
				.header("Content-Type", "application/json")
				.body(req_body.toJSONString())
				.when()
				.post(burl + "/auth/refresh")
				.then()
				.statusCode(200)
				.log().all()
				.extract().response();
    
		// Extract new token from the response
		String newToken = response.jsonPath().getString("token");
		System.out.println("New Token: " + newToken);
	}
	
	@Test
    public void fetchAllProducts() {
        // Sending GET request to fetch all products
        given()
            .when()
            .get(burl + "/products")
            .then()
            .statusCode(200)
            .log().all();
    }
	
	@Test
    public void fetchSingleProduct() {
        // Sending GET request to fetch a single product by ID
        given()
            .when()
            .get(burl + "/products/1")
            .then()
            .statusCode(200)
            .log().all();
    }
	
	@Test
    public void searchProducts() {
        // Sending GET request to search for products by query
        given()
            .when()
            .get(burl + "/products/search?q=phone")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void limitAndSkipProducts() {
        // Sending GET request to limit and skip products for pagination
        given()
            .when()
            .get(burl + "/products?limit=10&skip=10&select=title,price")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void sortProducts() {
        // Sending GET request to sort products by a specified field
        given()
            .when()
            .get(burl + "/products?sortBy=title&order=asc")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void getAllProductCategories() {
        // Sending GET request to get all product categories
        given()
            .when()
            .get(burl + "/products/categories")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void getProductsCategoryList() {
        // Sending GET request to get the category list of products
        given()
            .when()
            .get(burl + "/products/category-list")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void getProductsByCategory() {
        // Sending GET request to get products by a specific category
        given()
            .when()
            .get(burl + "/products/category/smartphones")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void addNewProduct() {
        // Creating JSON request body to add a new product
        JSONObject req_body = new JSONObject();
        req_body.put("title", "BMW Pencil");
        // Add other product data as needed

        // Sending POST request to add a new product
        given()
            .header("Content-Type", "application/json")
            .body(req_body.toJSONString())
            .when()
            .post(burl + "/products/add")
            .then()
            .statusCode(201)
            .log().all();
    }

    @Test
    public void updateProduct() {
        // Creating JSON request body to update a product
        JSONObject req_body = new JSONObject();
        req_body.put("title", "iPhone Galaxy +1");

        // Sending PUT request to update a product
        given()
            .header("Content-Type", "application/json")
            .body(req_body.toJSONString())
            .when()
            .put(burl + "/products/1")
            .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void deleteProduct() {
        // Sending DELETE request to delete a product by ID
        given()
            .when()
            .delete(burl + "/products/1")
            .then()
            .statusCode(200)
            .log().all();
    }
}
