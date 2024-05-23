package com.unac.stepsdefinitions;

import com.unac.apis.GoRestApi;
import com.unac.apis.entity.UserEntity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetGoRestStepsdefinitions {
    @Given("se establece la base url {string}")
    public void seEstableceLaBaseUrl(String baseUrl) {
        GoRestApi.setBaseUrl(baseUrl);
    }

    @When("se consulta en el endpoint {string} por id {string}")
    public void seConsultaEnElEndpointPorId(String endPoint, String idUser) {
        GoRestApi.executionGetToken(endPoint, idUser);
    }

    @Then("se valida que el status code {int} y que contenga el nombre {string}")
    public void seValidaQueElStatusCodeYQueContengaElNombre(Integer statusCode, String name) {
        GoRestApi.validateResponse(statusCode, name);
    }

    @When("se consulta el endpoint {string} por id {string} con el metodo PUT con el nombre {string} y el email " + "{string}")
    public void seConsultaElEnpointConMetodoPut(String endpoint, String idUser, String name, String email){
        UserEntity user = new UserEntity(name, email);
        GoRestApi.executionPutToken(endpoint, idUser, user);
    }

    @Then("se valida que el status code {int}, que contenga el nombre {string} y el email {string}")
    public void seValidaElStatusCodeNombreYEmail(Integer statusCode, String name, String email){
        GoRestApi.validateResponsePut(statusCode, name, email);
    }
}
