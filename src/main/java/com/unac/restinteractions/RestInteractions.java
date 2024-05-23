package com.unac.restinteractions;

import com.unac.apis.entity.UserEntity;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;


import static org.junit.Assert.assertEquals;

public class RestInteractions {

    @Before
    public void config(){
        setTheStage(new OnlineCast());
    }

    private static String baseUrl;

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.baseUrl = baseUrl;
    }

    public static void executionGetToken(String endPoint, String idUser, String token) {
        try {
            Response response = SerenityRest.given()
                    .auth().oauth2(token)
                    .contentType(ContentType.JSON)
                    .when()
                    .get(baseUrl.concat(endPoint).concat(idUser));

            response.prettyPeek();
        } catch (Exception e) {
            System.err.println("Error during GET request: " + e.getMessage());
        }
    }

    public static void executionPutToken(String endPoint, String idUser, String token, UserEntity upuser) {
        try {
            Response response = SerenityRest.given()
                    .auth().oauth2(token)
                    .contentType(ContentType.JSON)
                    .body(upuser)
                    .when()
                    .patch(baseUrl.concat(endPoint).concat(idUser));

            response.prettyPeek();
        } catch (Exception e) {
            System.err.println("Error during PUT request: " + e.getMessage());
        }
    }

    public static void validateStatusCode(Integer expectedStatusCode) {
        try {
            Integer actualStatusCode = SerenityRest.lastResponse().statusCode();
            assertEquals(expectedStatusCode, actualStatusCode);
        } catch (Exception e) {
            System.err.println("Error during validation: " + e.getMessage());
        }
    }

    public static void validateDataResponse(String name, String pathName) {
        try {
            String actuaName = SerenityRest.lastResponse().jsonPath().getString(pathName);
            assertEquals(actuaName, name);
        } catch (Exception e) {
            System.err.println("Error during validation: " + e.getMessage());
        }
    }
}
