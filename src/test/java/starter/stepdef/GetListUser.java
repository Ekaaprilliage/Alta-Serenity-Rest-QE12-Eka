package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.GetListUserAPI;
import starter.Reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetListUser {

    @Steps
    GetListUserAPI getListUserAPI;
    @Given("Get List users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        getListUserAPI.GetListUsers(page);
    }

    @When("Send Request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(GetListUserAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Validate get list users JSON schema {string}")
    public void validateGetListUsersJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get List users with exceed parameter page {int}")
    public void getListUsersWithExceedParameterPage(int page) {
        getListUserAPI.GetListUsersNotFound(page);
    }

    @When("Send Request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(GetListUserAPI.GET_LIST_USERS_NOT_FOUND);
    }

    @Then("Get list Status code should be {int} Bad User")
    public void getListStatusCodeShouldBeBadUser(int baduser) {
        SerenityRest.then().statusCode(baduser);
    }
}
