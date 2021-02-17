package restassured.api;

import io.restassured.response.Response;
import restassured.utils.ApiUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;
import static restassured.utils.ApiUri.Market_Place_URI;

public class MarketPlace extends ApiUtils {
    public MarketPlace() {
        super(JSON, "owm44095@cuoly.com");
    }

    public void getResponseWithoutFilteration(){
        Response response =sendGetRequest(Market_Place_URI.uri());
        assertResponseSucceeded(response);
    }


    public void getResponseWithFiltration(){
        Map<String, Object> parameters = new HashMap<String, Object>() {{
            put("lang","3");
            put("lat", "3");}};
        Response response =sendPostRequestWithQueryParameters(Market_Place_URI.uri(),parameters);
        assertResponseSucceeded(response);
    }
}
