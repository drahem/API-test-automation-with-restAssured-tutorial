package org.example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestAuth {

    String token = "";

    @Test(priority = 0)
    public void testLogin(){
        String body = "{\n" +
                "    \"email\":\"superman@gmail.com\",\n" +
                "    \"password\":\"123456\"\n" +
                "}";
        Response login = given().header("Content-Type", "application/json")
                .body(body)
                .post("https://apingweb.com/api/login");
        Assert.assertEquals(login.statusCode(),200);
        Assert.assertEquals(login.body().jsonPath().get("message"), "Login success");
        Assert.assertEquals(login.body().jsonPath().get("result.email"), "superman@gmail.com");
        token = login.body().jsonPath().get("token");
    }

    @Test(priority = 1)
    public void testGetArticles(){

        Response articles = given().auth().oauth2(token)
                .when().get("https://apingweb.com/api/articles");
        articles.prettyPrint();

    }

    @Test
    public void testGetUsers(){

        Response users = given().auth().basic("admin", "12345")
                .when().get("https://apingweb.com/api/auth/users");
        users.prettyPrint();
    }
}
