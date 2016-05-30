
package org.aat.iot.demo.infopicker;

import java.io.IOException;

import org.aat.iot.demo.infopicker.utils.InfoPickerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>InfoPickerApplication</h1>
 * <p>
 * This class contains the project main from which the application laucher is started.
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */

public final class InfoPickerApplication {

  private static final Logger LOG = LoggerFactory.getLogger(InfoPickerApplication.class);

  private static InfoPickerApplication instance = new InfoPickerApplication();
  static InfoPickerLauncher launcher = new InfoPickerLauncher();

  private InfoPickerApplication() {

  }

  /**
   * This is the method from which the application calls the launcher to start the app.
   * 
   * @param args unused.
   * @return none
   */

  public static void main(String[] args) {

    try {
      launcher.loadPropertyFile(InfoPickerConstants.PROPERTY_FILE);
      launcher.startApp(new AppIotPlatformFactory());
    } catch (IOException e) {
      LOG.error("The property file is missing or corrupted" + e.getLocalizedMessage(), e);
    }

  }

  /**
   * Sets the launcher instance.
   * 
   * @param an instance of InfoPickerLauncher.
   * @return none
   */

  public static void setLauncher(InfoPickerLauncher infoLauncher) {
    InfoPickerApplication.launcher = infoLauncher;
  }

  /**
   * Retrieves the launcher instance.
   * 
   * @param none.
   * @return instance of InfoPickerLauncher
   */

  public static InfoPickerApplication getInstance() {
    return instance;
  }



}
