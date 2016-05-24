package org.aat.iot.demo.infopicker.utils;

/**
 * <h1>Utility</h1> 
 * <p> The utility class used the application
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */

public class Utility {

  private Utility() {}

  public static <E extends Enum<E>> boolean isInEnum(String appName, Class<E> enumClass) {
    for (E element : enumClass.getEnumConstants()) {
      if (element.name().equals(appName))
        return true;
    }
    return false;
  }

}
