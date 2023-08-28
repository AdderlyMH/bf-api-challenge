package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.BuildTestData;
import resources.Utility;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinition extends Utility {

    RequestSpecification payloadReq;
    ResponseSpecification baseResp;
    Response response;
    BuildTestData testData = new BuildTestData();
    static String pet_id;

    @Given("a payload with parameters {int} {int} {string} {string} {string} {int} {string} {string}")
    public void aPayloadWithParameters(int id, int cat_id, String cat_name, String name, String photoUrls, int tags_id,
                                       String tags_name, String status) throws IOException {

        payloadReq = given().spec(requestSpecification()).body(testData.addPetPayload(id, cat_id, cat_name, name,
                photoUrls, tags_id, tags_name, status));

    }

    @When("user sends a {string} request from the API PET v2")
    public void userSendsARequestFromTheAPI(String requestType) {

        baseResp = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).build();

        if (requestType.equalsIgnoreCase("POST"))
            response = payloadReq.when().post().then().spec(baseResp).extract().response();
        else if (requestType.equalsIgnoreCase("GET"))
            response = payloadReq.when().get(pet_id).then().spec(baseResp).extract().response();
        else if (requestType.equalsIgnoreCase("PUT"))
            response = payloadReq.when().put().then().spec(baseResp).extract().response();

    }

    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int statusCode) {
        pet_id = getJsonPath(response,"id");
        assertEquals(response.getStatusCode(), statusCode);
    }

    @And("the {string} field value is {string}")
    public void theFieldValueIs(String fieldName, String fieldValue) {
        assertEquals(getJsonPath(response, fieldName), fieldValue);
    }

    @Given("a payload file named {string}")
    public void aPayloadFileNamed(String fileName) throws IOException {
        payloadReq = given().spec(requestSpecification()).body(testData.addPetFile(fileName));
    }

    @Given("a previously created pet")
    public void aPreviouslyCreatedPet() throws IOException {
        payloadReq = given().spec(requestSpecification());
    }

    @Given("a string payload")
    public void aStringPayload() throws IOException {
        payloadReq = given().spec(requestSpecification()).body(testData.updatePetPayload(pet_id));
    }

}
