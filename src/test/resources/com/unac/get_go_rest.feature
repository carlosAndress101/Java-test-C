Feature: automatizacion de rest api - pom
  yo como estudiante de calidad de software
  necesito construir una petición a una api
  para aprender a automatizar servicios

  Scenario: consultar un usuario con metodo get
    Given se establece la base url "https://gorest.co.in/"
    When se consulta en el endpoint "public/v2/users/" por id "6920258"
    Then se valida que el status code 200 y que contenga el nombre "Anuraag Sharma"

  Scenario: actualiazr un usuario con metodo PUT
    Given se establece la base url "https://gorest.co.in/"
    When se consulta el endpoint "public/v2/users/" por id "6920258" con el metodo PUT con el nombre "Anuraag Sharma" y el email "Anuraag_sharma@armstrong-bartell.test"
    Then se valida que el status code 200, que contenga el nombre "Anuraag Sharma" y el email "Anuraag_sharma@armstrong-bartell.test"

