package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostRegisterSuccesAPI {
    public static String POST_REGISTER_SUCCESS = Constants.BASE_URL+"/api/register";
    public static String POST_REGISTER_UNSUCCESS = Constants.BASE_URL+"/api/register";

    @Step("Post Register a new user")
    public void postRegisterNewUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Register user without password")
    public void postRegisterWithoutPassword(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
