package api;

import core.utils.PropertyHelper;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HealthCheckTest {

  @Test
  public void healthCheck() {
    Assert.assertEquals(
        RestAssured.get(PropertyHelper.getPropertyByKey("regula.startPage.url")).statusCode(), 200);
  }
}
