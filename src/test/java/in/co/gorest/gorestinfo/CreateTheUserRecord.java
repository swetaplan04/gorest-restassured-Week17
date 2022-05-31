package in.co.gorest.gorestinfo;

import in.co.gorest.model.GorestPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateTheUserRecord extends TestBase {

    @Test
    public void CreateTheUserpage() {

        GorestPojo gorestPojo = new GorestPojo();
        gorestPojo.setName("Tenali Ramakrishna");
        gorestPojo.setGender("female");
        gorestPojo.setEmail("tenali.ramakrishn7@gmail.com");
        gorestPojo.setStatus("active");

        Response response = given()
                .header("Authorization", "Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                .header("Content-Type", "application/json")
                .body(gorestPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}



