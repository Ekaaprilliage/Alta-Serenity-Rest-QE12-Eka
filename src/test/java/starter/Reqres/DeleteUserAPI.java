package starter.Reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DeleteUserAPI {
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_INVALID_USER = Constants.BASE_URL+"/api/users/{id}";
    @Step("Delete a user")
    public void DeleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);

    }

    @Step("Delete invalid user")
    public void DeleteInvalidUser(Object param) {
        SerenityRest.given()
                .pathParam("id", param);

    }
}
