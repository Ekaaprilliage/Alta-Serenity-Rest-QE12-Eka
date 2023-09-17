package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostLoginSuccesAPI {
    public static String POST_LOGIN_SUCCESS = Constants.BASE_URL+"/api/login";
    public static String POST_LOGIN_UNSUCCESS = Constants.BASE_URL+"/api/login";

    @Step("Post Login a new user")
    public void postLoginNewUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Login user without password")
    public void postLoginWithoutPass(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}

