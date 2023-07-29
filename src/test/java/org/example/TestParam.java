package org.example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestParam {

    @DataProvider
    public Object[] listOfIds(){
        Object data[] = {1,2,3,4,5,6,7,8,9,10,1000};
        return data;
    }

    @Test(dataProvider = "listOfIds")
    public void testGetActivity(int id){

        Response activity = given().pathParam("id",id)
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities/{id}");

        Assert.assertEquals(activity.statusCode(), 200);
        Assert.assertEquals(activity.body().jsonPath().get("id"), id);
        Assert.assertEquals(activity.body().jsonPath().get("title"),"Activity "+id);

    }

    @Test(dataProvider = "listOfIds")
    public void testGetUsers(int pageNo){

        Response users = given().queryParam("page", pageNo)
                .when().get("https://reqres.in/api/users");
        Assert.assertEquals(users.statusCode(), 200);
        Assert.assertEquals(users.body().jsonPath().get("page"),pageNo);
    }
}
