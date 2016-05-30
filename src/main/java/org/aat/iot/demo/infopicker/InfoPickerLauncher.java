package org.aat.iot.demo.infopicker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.aat.iot.demo.infopicker.utils.ConsumerApps;
import org.aat.iot.demo.infopicker.utils.InfoPickerConstants;
import org.aat.iot.demo.infopicker.utils.IotServer;
import org.aat.iot.demo.infopicker.utils.Utility;

/**
 * <h1>InfoPickerLauncher</h1>
 * <p>
 * This class loads the application property file "local.properties".
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */


public class InfoPickerLauncher {

  Properties prop = new Properties();
  InputStream input = null;
  AppIotPlatformFactory appIotPlatformFactory;
  ConsumerApplication consumerApplication;

  /**
   * It loads the property file name. All the input argument to the application can be loaded from
   * the propery file
   * 
   * @param the property file name
   * @throws IOException
   */
  public void loadPropertyFile(String propertyFileName) throws IOException {
    loadFile(propertyFileName);
  }

  /**
   * Starts the application by invoking the appropriate consumer App by giving the application name
   * and Iot server used.
   * 
   * @param appIotPlatformFactory
   */
  public void startApp(AppIotPlatformFactory appIotPlatformFactory) {

    consumerApplication =
        appIotPlatformFactory.getIotInstance(getApplicationName(), getIotServerName());
    consumerApplication.displayInformation();

  }

  /**
   * Loads the property file
   * 
   * @param propertyFileName
   * @throws IOException
   */

  private void loadFile(String propertyFileName) throws IOException {
    input = new FileInputStream(propertyFileName);
    prop.load(input);
  }

  /**
   * Gets the application from the loaded property file.
   * 
   * @return ConsumerApp enum item
   */
  public ConsumerApps getApplicationName() {
    boolean isValueInEnum = true;
    String appName = getPropertyValue(InfoPickerConstants.PROPERTY_CONSUMER_APP);
    if (appName != null)
      isValueInEnum = Utility.isInEnum(appName.toUpperCase(), ConsumerApps.class);
    return (appName == null || !isValueInEnum) ? ConsumerApps.DEFAULT
        : ConsumerApps.valueOf(appName.toUpperCase());
  }


  public String getPropertyValue(String propertyName) {
    return prop.getProperty(propertyName);
  }

  /**
   * Gets the server name from the loaded property file.
   * 
   * @return IotServer enum item
   */
  public IotServer getIotServerName() {
    boolean isValueInEnum = true;
    String serverName = getPropertyValue(InfoPickerConstants.PROPERTY_IOTSERVER);
    if (serverName != null)
      isValueInEnum = Utility.isInEnum(serverName.toUpperCase(), IotServer.class);

    return (serverName == null || !isValueInEnum) ? IotServer.DEFAULT
        : IotServer.valueOf(serverName.toUpperCase());
  }

}
