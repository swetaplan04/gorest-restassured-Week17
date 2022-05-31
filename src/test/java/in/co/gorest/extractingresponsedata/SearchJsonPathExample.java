package in.co.gorest.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .queryParam("page",2)
                .when()
                .get("/users")
                .then().statusCode(200);
    }


    // 1) to verify Total records are 20
    @Test
    public void test001() {
        List<String> data = response.extract().path("");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total records are  : " + data.size());
        System.out.println("------------------End of Test---------------------------");

    }

    // 2) id 3199 has name = Kamla Kaniyar
    @Test
    public void test002() {
        int id = response.extract().path("[2].id");
        String name = response.extract().path("[2].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of name has id is 3199 : " + id);
        System.out.println("The value of name has id is 3199 : " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3) id 3199 has email = "birjesh_acharya@brown.net"
    @Test
    public void test003() {
        int id = response.extract().path("[2].id");
        String email = response.extract().path("[2].email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of name has id is 3199 : " + id);
        System.out.println("The value of name has id is 3199 : " + email);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) All ID has status = active
    @Test
    public void test004() {

        List<String> status = response.extract().path("status");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Value message : " + status);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5) id 3199 has gender = "female"
    @Test
    public void test005() {
        int id = response.extract().path("[2].id");
        String gender = response.extract().path("[2].gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of name has id is 3199 : " + id);
        System.out.println("The value of gender has id is 3199 : " + gender);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) id 3198 has gender = "male"
    @Test
    public void test006() {

        int id = response.extract().path("[3].id");
        String gender = response.extract().path("[3].gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of name has id is 3198 : " + id);
        System.out.println("The value of gender has id is 3198 : " + gender);
        System.out.println("------------------End of Test---------------------------");
    }


}
