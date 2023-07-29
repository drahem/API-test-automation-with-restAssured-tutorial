package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.Serialization.OrderDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestOrders {

    @Test
    public void testOrderData() throws JsonProcessingException {

        OrderDetails order = new OrderDetails();
        order.setId(1);
        order.setPetId(2);
        order.setQuantity(1);
        order.setShipDate("2023-07-08T10:46:56.086Z");
        order.setStatus("in progress");
        order.setComplete(false);

        ObjectMapper mapper = new ObjectMapper();
        String bodyData = mapper.writeValueAsString(order);

        Response res = given().contentType(ContentType.JSON).
                body(bodyData)
                .when().post("https://petstore.swagger.io/v2/store/order");
        res.prettyPrint();

        OrderDetails responseData = res.body().as(OrderDetails.class);

        Assert.assertEquals(responseData.getId(),order.getId());
        Assert.assertEquals(responseData.getQuantity(),order.getQuantity());
    }
}
