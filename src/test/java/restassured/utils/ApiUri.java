package restassured.utils;

import constants.EndPoints;
import org.openqa.selenium.By;

public enum ApiUri implements EndPoints {
    ;

    private String uri;

    ApiUri (String uri) {
        this.uri =uri;
    }
    @Override
    public String uri() {
        return uri;
    }
}
