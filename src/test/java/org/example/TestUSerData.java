package org.example;

import io.restassured.response.Response;
import org.example.DeSerialization.ListOfUsers;
import org.example.DeSerialization.user;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestUSerData {

    @Test
    public void testSingleUser(){
        Response userResponse = given().when().get("https://reqres.in/api/users/2");
        Assert.assertEquals(userResponse.statusCode(), 200);

        user userData = userResponse.body().as(user.class);

        Assert.assertEquals(userData.getData().getId(), 2);
        Assert.assertEquals(userData.getData().getEmail(), "janet.weaver@reqres.in");
        Assert.assertEquals(userData.getData().getFirstName(), "Janet");
        Assert.assertEquals(userData.getData().getLastName(), "Weaver");
        Assert.assertEquals(userData.getData().getAvatar(), "https://reqres.in/img/faces/2-image.jpg");



    }

    @Test
    public void testListOfUsers(){
        Response users = given().when().get("https://reqres.in/api/users?page=1");
        Assert.assertEquals(users.statusCode(), 200);

        ListOfUsers usersList = users.body().as(ListOfUsers.class);

        Assert.assertEquals(usersList.getPage(), 1);
        Assert.assertEquals(usersList.getTotal(), 12);
        Assert.assertEquals(usersList.getPerPage(), 6);
        Assert.assertEquals(usersList.getTotalPages(), 2);

        Assert.assertEquals(usersList.getData().get(0).getId(), 1);
        Assert.assertEquals(usersList.getData().get(1).getId(), 2);


    }
}
