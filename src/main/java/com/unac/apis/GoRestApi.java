package com.unac.apis;

import com.unac.apis.entity.UserEntity;
import com.unac.restinteractions.RestInteractions;

public class GoRestApi {

    private static final String TOKEN = "01684339217098008f996259129812ca579f0460ce05f723b9f7e9e7bd092a8f";
    private static String pathNameRest = "Anuraag Sharma";
    private static String pathName = "name";
    private static String pathEmail = "email";

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.setBaseUrl(baseUrl);
    }

    public static void executionGetToken(String endPoint, String idUser){
        RestInteractions.executionGetToken(endPoint,idUser,TOKEN);
    }

    public static void executionPutToken( String endPoint, String idUser,  UserEntity upuser) {
        RestInteractions.executionPutToken(endPoint, idUser, TOKEN, upuser);
    }

    public static void validateResponse(Integer statusCode, String name) {
        RestInteractions.validateStatusCode(statusCode);
        RestInteractions.validateDataResponse(name, pathNameRest);
    }

    public static void validateResponsePut(Integer statusCode, String name, String email){
        RestInteractions.validateStatusCode(statusCode);
        RestInteractions.validateDataResponse(name, pathName);
        RestInteractions.validateDataResponse(email, pathEmail);
    }
}
