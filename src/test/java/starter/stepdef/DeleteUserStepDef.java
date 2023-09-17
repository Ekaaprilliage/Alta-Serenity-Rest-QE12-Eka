package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.DeleteUserAPI;
import starter.Reqres.ReqresResponses;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteUserStepDef {

    @Steps
    DeleteUserAPI deleteUserAPI;
    @Given("Delete a user with valid user id {int}")
    public void deleteAUserWithValidUserId(int id) {
        deleteUserAPI.DeleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(DeleteUserAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("Delete a user with invalid user id {}")
    public void deleteAUserWithInvalidUserId(Object param) {
        deleteUserAPI.DeleteInvalidUser(param);
    }
    @Then("Status code should be {int} Bad request")
    public void statusCodeShouldBeBadRequest(int badrequest) {
        SerenityRest.then().statusCode(badrequest);
    }

//    @Given("Delete a user with invalid user id {int}")
//    public void deleteAUserWithInvalidUserId(int id) {
//        deleteUserAPI.DeleteInvalidUser(id);
//    }
//    @Given("Delete a user with invalid user id {int}")
//    public void deleteAUserWithInvalidUserId(int id) {
//        deleteUserAPI.DeleteInvalidUser(id);
//    }
}
