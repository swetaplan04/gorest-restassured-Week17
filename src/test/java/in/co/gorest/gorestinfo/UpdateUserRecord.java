package in.co.gorest.gorestinfo;

import in.co.gorest.model.GorestPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateUserRecord extends TestBase {

    @Test
    public void updateUserRecord(){
        GorestPojo gorestPojo = new GorestPojo();
        gorestPojo.setName("Priyala Ahuja");
        gorestPojo.setGender("female");
        gorestPojo.setEmail("dhawan_vaijayanti@yundt-bechtelar.org");
        gorestPojo.setStatus("active");

        Response response = given()
                .header("Authorization","Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                .header("Content-Type", "application/json")
                .pathParam("id", 3229)
                .body(gorestPojo)
                .when()
                .patch("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
