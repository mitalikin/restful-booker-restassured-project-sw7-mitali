package com.restful.booker.crudtest;

import com.restful.booker.model.UserPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

@Test

public void verifyUserCreatedSuccessfully() {

    UserPojo userPojo=new UserPojo();
    userPojo.setFirstname("John");
    userPojo.setLastname("White");
    userPojo.setTotalprice(150);
    userPojo.setDepositpaid(true);
    userPojo.setAdditionalneeds("Breakfast");

    Response response=given().log().all()
            .headers("Content-Type","application/json")
            .when()
            .body(userPojo)
            .post();
    response.prettyPrint();
    response.then().log().all().statusCode(200);





}



}
