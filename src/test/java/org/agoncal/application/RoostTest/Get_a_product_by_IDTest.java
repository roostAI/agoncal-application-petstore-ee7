/*
Test generated by RoostGPT for test postman-test using AI Type Azure Open AI and AI Model roost-gpt4-32k

{
  background: null,
  rule: null,
  scenario: 'Get a product by ID\r\n' +
    '    Given there is an existing product with ID 1\r\n' +
    '    When the client sends a GET request "/api/products/1" to get a product by its id\r\n' +
    '    Then the response status code should be 200\r\n' +
    '    And the response should contain the product with ID 1',
  title: 'Get a product by ID'
}

*/package org.agoncal.application.RoostTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoostTest {
    @Test
    public void GetProductById() {
        // Configuring REST Assured
        RestAssured.baseURI = System.getenv("ROOST_SERVER_URL");
        RestAssured.basePath = "/api/products";
        
        // Creating a GET request
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/1");

        // Asserting the status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Expected response code is 200.");

        // Asserting the product id in the response
        String id = response.getBody().jsonPath().get("id");
        Assert.assertEquals(id, "1", "Expected product ID in response is 1");
    }
}
