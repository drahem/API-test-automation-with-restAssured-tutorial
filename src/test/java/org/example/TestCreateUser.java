package org.example;

import io.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TestCreateUser {
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testCreateUser(){

        String body = "{\n" +
                "    \"id\":9999,\n" +
                "    \"userName\":\"user9999\",\n" +
                "    \"password\":\"pass9999\"\n" +
                "}";

        JSONObject bodyData = new JSONObject();
        bodyData.put("id",1000);
        bodyData.put("userName" , "user1000");
        bodyData.put("password","pass1000");

        Response user = given().header("Content-Type" , "Application/JSON")
                .body(bodyData.toString())
                .when().post("https://fakerestapi.azurewebsites.net/api/v1/Users");
        user.prettyPrint();
        Assert.assertEquals(user.statusCode(), 200);
    }

    @Test
    public void testStore() throws IOException {
/*
        OrderDetails order  = new OrderDetails();
        order.setId(123);
        order.setPetId(999);
        order.setQuantity(2);
        order.setShipDate("2023-07-08T10:46:56.086Z");
        order.setStatus("in progress");
        order.setComplete(false);

        String body = mapper.writeValueAsString(order);

        Response res = given().contentType(ContentType.JSON)
                .body(body)
                .when().post("https://petstore.swagger.io/v2/store/order");

        res.prettyPrint();

        OrderDetails response = res.body().as(OrderDetails.class);
*/
    }


}
