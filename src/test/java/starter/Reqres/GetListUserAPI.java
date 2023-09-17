package starter.Reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetListUserAPI {
    public static String GET_LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";
    public static String GET_LIST_USERS_NOT_FOUND = Constants.BASE_URL+"/api/users?page={page}";

    @Step("Get List Users")
    public void  GetListUsers(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get List Users Not Found")
    public void  GetListUsersNotFound(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }
}
