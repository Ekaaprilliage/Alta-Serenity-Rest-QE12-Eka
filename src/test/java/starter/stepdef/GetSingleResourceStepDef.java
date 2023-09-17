package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.GetSingleResourceAPI;
import starter.Reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;


public class GetSingleResourceStepDef {

    @Steps
    GetSingleResourceAPI getSingleResourceAPI;

    @Given("Get Single Resource users with valid id {}")
    public void getSingleResourceUsersWithValidId(Object id) {
        getSingleResourceAPI.getSingleResource(id);
    }

    @When("Send Request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(GetSingleResourceAPI.GET_SINGLE_RESOURCE);
    }

    @Then("Status codeget single resource should be {int} OK")
    public void statusCodegetSingleResourceShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }


    @And("Response body single resource should be {}")
    public void responseBodySingleResourceShouldBe(int resource) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(resource));
    }

    @And("Validate get single resource users JSON schema {string}")
    public void validateGetSingleResourceUsersJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));

    }

    @Given("Get Single Resource users with invalid id {}")
    public void getSingleResourceUsersWithInvalidId(Object id) {
        getSingleResourceAPI.getSingleResource(id);
    }

    @Then("Status code get single resource should be {int} Not Found")
    public void statusCodeGetSingleResourceShouldBeNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }
}
