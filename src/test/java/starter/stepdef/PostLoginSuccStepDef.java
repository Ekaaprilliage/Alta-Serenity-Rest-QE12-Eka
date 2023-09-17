package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.PostLoginSuccesAPI;
import starter.Reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostLoginSuccStepDef {
    @Steps
    PostLoginSuccesAPI postLoginSuccesAPI;
    @Given("Login a new user with valid json {string}")
    public void loginANewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        postLoginSuccesAPI.postLoginNewUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(PostLoginSuccesAPI.POST_LOGIN_SUCCESS);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int ok) {
        SerenityRest.then().statusCode(ok);

    }


    @And("Validate post login a users JSON schema {string}")
    public void validatePostLoginAUsersJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Login user with valid email without password {string}")
    public void loginUserWithValidEmailWithoutPassword(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        postLoginSuccesAPI.postLoginNewUser(json);
    }

    @When("Send request post login user without password")
    public void sendRequestPostLoginUserWithoutPassword() {
        SerenityRest.when().post(PostLoginSuccesAPI.POST_LOGIN_UNSUCCESS);
    }

    @And("Validate post login user JSON schema {string}")
    public void validatePostLoginUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));

    }

    @And("Response body token error message was {string}")
    public void responseBodyTokenErrorMessageWas(String eror) {
        SerenityRest.and().body(ReqresResponses.ERROR_MESSAGE,equalTo(eror));
    }
}
