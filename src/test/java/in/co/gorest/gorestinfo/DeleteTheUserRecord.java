package in.co.gorest.gorestinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteTheUserRecord extends TestBase {

    @Test
    public void deleteUsersRecord(){
        Response response = given()
                .header("Authorization","Bearer ba41816a2250d319d94b675bc82065a88bf3a7bdf4783dce41165818018dd9b3")
                .pathParam("id",4042)
                .when()
                .delete("/users/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}

