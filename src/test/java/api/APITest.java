package api;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITest {

    @Test
    public void testGetRequest(){

        given().when().get("https://fake-json-api.mock.beeceptor.com/users").then().statusCode(200).and().assertThat().body("name", notNullValue());
        int statusCode = given().when().get("https://fake-json-api.mock.beeceptor.com/users").statusCode();
        String body = given().when().get("https://fake-json-api.mock.beeceptor.com/users").getBody().asString();

        System.out.println(statusCode);
        System.out.println(body);
    }
}
