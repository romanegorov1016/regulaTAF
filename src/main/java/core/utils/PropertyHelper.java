package core.utils;

import core.utils.exceptions.PreventInstantiationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

/** Can be used to get property value from config.properties file by key */
@Log4j2
public final class PropertyHelper {

  private static Properties property = new Properties();

  private PropertyHelper() {
    throw new PreventInstantiationException();
  }

  @SneakyThrows
  public static String getPropertyByKey(String propertyKey) {
    String propertyValue;
    try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
      property.load(fis);
      propertyValue = property.getProperty(propertyKey);
    } catch (IOException ioEx) {
      log.error("Properties file was not found");
      throw ioEx;
    }
    return propertyValue;
  }
}
