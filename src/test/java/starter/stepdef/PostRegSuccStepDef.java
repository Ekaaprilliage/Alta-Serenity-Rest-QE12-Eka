package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.PostRegisterSuccesAPI;
import starter.Reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostRegSuccStepDef {

    @Steps
    PostRegisterSuccesAPI postRegisterSuccesAPI;
    @Given("Register a new user with valid json {string}")
    public void registerANewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        postRegisterSuccesAPI.postRegisterNewUser(json);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(PostRegisterSuccesAPI.POST_REGISTER_SUCCESS);
    }

    @Then("Status code should be {int} ok")
    public void statusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Response body token was {string}")
    public void responseBodyTokenWas(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate post register a users JSON schema {string}")
    public void validatePostRegisterAUsersJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Register a user without password {string}")
    public void registerAUserWithoutPassword(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        postRegisterSuccesAPI.postRegisterWithoutPassword(json);
    }

    @When("Send request post register user without password")
    public void sendRequestPostRegisterUserWithoutPassword() {
        SerenityRest.when().post(PostRegisterSuccesAPI.POST_REGISTER_UNSUCCESS);
    }

    @And("Validate login user without password {string}")
    public void validateLoginUserWithoutPassword(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }

    @And("Response body token erorr message was {string}")
    public void responseBodyTokenErorrMessageWas(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR_MESSAGE,equalTo(error));
    }
}
