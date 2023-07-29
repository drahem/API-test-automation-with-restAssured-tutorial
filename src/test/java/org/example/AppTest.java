package org.example;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class AppTest
{

    @Test
    public void testStatusCode(){
        int pageNo = 1;
        RestAssured.baseURI = "https://reqres.in";
        Response res1 = given().queryParam("page", pageNo)
                .when().get("/api/users");
        res1.prettyPrint();
        Assert.assertEquals(res1.statusCode(), 200,"response status code is not 200 as expected");
        Assert.assertEquals(res1.body().jsonPath().get("page"), pageNo, "page number is incorrect");
        System.out.println("total_pages = " + res1.body().jsonPath().get("total_pages"));
        System.out.println("total = " + res1.body().jsonPath().get("total"));
        System.out.println("all IDs = " + res1.body().jsonPath().get("data.id"));
        System.out.println("first ID = " + res1.body().jsonPath().get("data.id[0]"));

    }




}
