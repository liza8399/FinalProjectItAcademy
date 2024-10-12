package com.itacademy.apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class APILamodaTest {

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = "https://www.lamoda.by/";
    }

    @Test
    public void loginTest(){
        File file = new File("src/test/resources/json/login.json");
        RestAssured.given().log().uri().contentType(ContentType.JSON)
                .body(file)
                .when().post("api/v1/customer/auth").
                then().log().all().statusCode(403);
    }

    @Test
    public void getCaptchaTest(){
        RestAssured.given().log().uri().
                when().get("apix/captcha/?action=login&t=1728146148357").
                then().log().all().statusCode(300)
                        .body("sitekey",equalTo("6LcCcfISAAAAAGsXZrTGmEiFFResG_0d_xfCo4Ha"))
                        .body("status",equalTo("ok"))
                        .body("action",equalTo("captcha"));
    }

    @Test
    public void getSearchTest(){
        RestAssured.given().log().uri().
                when().get("catalogsearch/result/?q=%D1%85%D1%83%D0%B4%D0%B8%20%D0%B6%D0%B5%D0%BD%D1%81%D0%BA%D0%BE%D0%B5&submit=y&gender_section=women").
                then().log().all().statusCode(200);
    }

    @Test
    public void getSortFilterTest(){
        RestAssured.given().log().uri().
                when().get("catalogsearch/result/?q=%D1%85%D1%83%D0%B4%D0%B8+%D0%B6%D0%B5%D0%BD%D1%81%D0%BA%D0%BE%D0%B5&submit=y&gender_section=women&sort=price_asc&json=1").
                then().log().all().statusCode(200);
    }
}
