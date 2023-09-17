package starter.Reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;


public class GetSingleResourceAPI {
    public static String GET_SINGLE_RESOURCE = Constants.BASE_URL+"/api/unknown/{id}";

    @Step("Get Single Resource")
    public void  getSingleResource(Object resource) {
        SerenityRest.given()
                .pathParam("id", resource);
    }
}
