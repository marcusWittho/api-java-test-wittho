package org.wittho;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonTest {

  @Test
  public void testPerson() {
    given()
      .when().get("/home/test")
      .then()
          .statusCode(200)
          .body(is("Ok!"));
  }
}
