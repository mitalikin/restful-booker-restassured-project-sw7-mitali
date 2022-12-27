package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class IndexExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking")
                .then().statusCode(200);

    }
    //Verify total booking id
    @Test
    public void test001() {
        response.body("bookingid.size", greaterThan(10));

    }

    // Extract the All records
    @Test
    public void test002() {
        List<Integer> records = response.extract().path("bookingid");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The list of All id is : " + records);
        System.out.println("------------------End of Test---------------------------");
    }

    //get size of bookingId
    @Test
    public void test003() {
        List<Integer> listOfId = response.extract().path("bookingid");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The list of All id is : " + listOfId.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the id of 5th object
    @Test
    public void test004() {
        Integer listOf5thObject = response.extract().path("[5].bookingid");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th object : " + listOf5thObject);
        System.out.println("------------------End of Test---------------------------");

    }
    //4  Extract the id =666 object
    @Test
    public void test005() {
        Integer listOf5thObject = response.extract().path("[7].bookingid");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id =666  : " + listOf5thObject);
        System.out.println("------------------End of Test---------------------------");

    }
}
