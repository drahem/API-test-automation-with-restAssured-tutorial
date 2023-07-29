package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.DeSerialization.Activity;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestActivities {

    @Test
    public void testGetActivity(){

        Response res = given().contentType(ContentType.JSON)
                .when().get("https://fakerestapi.azurewebsites.net/api/v1/Activities/1");
        res.prettyPrint();

        Activity data = res.body().as(Activity.class);

        Assert.assertEquals(data.getId(), 1);
        Assert.assertEquals(data.isCompleted(), false);
    }

    @Test
    public void testGetActivities(){

        Response res = given().contentType(ContentType.JSON)
                .when().get("https://fakerestapi.azurewebsites.net/api/v1/Activities");
        res.prettyPrint();

        Activity[] data = res.body().as(Activity[].class);

        boolean status = false;
        int j = 1;
        for (int i=0;i<data.length;i++){
            Assert.assertEquals(data[i].getId(), j);
            Assert.assertEquals(data[i].getTitle(), "Activity "+ j);
            Assert.assertEquals(data[i].isCompleted(), status);
            status = !status;
            j++;

        }
    }
}
