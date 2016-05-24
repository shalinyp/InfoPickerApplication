package org.aat.iot.demo.infopicker.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.aat.iot.demo.infopicker.AppIotPlatformFactory;
import org.aat.iot.demo.infopicker.ConsumerApplication;
import org.aat.iot.demo.infopicker.InfoPickerLauncher;
import org.aat.iot.demo.infopicker.defaultapplication.DefaultApplication;
import org.aat.iot.demo.infopicker.defaultapplication.GeoLocatorApplication;
import org.aat.iot.demo.infopicker.services.GeoLocatorController;
import org.aat.iot.demo.infopicker.utils.ConsumerApps;
import org.aat.iot.demo.infopicker.utils.InfoPickerConstants;
import org.aat.iot.demo.infopicker.utils.IotServer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class InfoPickerLauncherTest {

  // Class under Test
  InfoPickerLauncher launcher;
  Properties prop = new Properties();
  OutputStream output = null;

  @Before
  public void beforeTest() throws IOException {
    output = new FileOutputStream(TestConstants.PROPERTY_FILE_TEST);
    launcher = new InfoPickerLauncher();

  }


  private void writeTestPropertyValues(String key, String value) throws IOException {
    prop.setProperty(key, value);
    prop.store(output, null);
    launcher.loadPropertyFile(TestConstants.PROPERTY_FILE_TEST);

  }

  @Test
  public void checkIfThePropertyFileIsLoadedProperly() {
    InfoPickerLauncher launcher = new InfoPickerLauncher();
    try {
      launcher.loadPropertyFile(TestConstants.PROPERTY_FILE_TEST);
    } catch (IOException ex) {
      fail("Property File not loaded");
    }
  }

  @Test(expected = IOException.class)
  public void checkIfIOExceptionIsThrownIfInvalidFile() throws IOException {
    launcher.loadPropertyFile("dummy.properties");
  }

  @Test
  public void checkIfAppNameIsReturnedAsDefaultOnNullProperty() throws IOException {
    writeTestPropertyValues(InfoPickerConstants.PROPERTY_CONSUMER_APP, "");
    assertEquals(ConsumerApps.DEFAULT, launcher.getApplicationName());
  }

  @Test
  public void checkIfAppNameIsReturnedAsDefaultOnInvalidProperty() throws IOException {
    writeTestPropertyValues(InfoPickerConstants.PROPERTY_CONSUMER_APP, "TestApp");
    assertEquals(ConsumerApps.DEFAULT, launcher.getApplicationName());
  }

  @Test
  public void checkIfCorrectAppNameIsReturnedOnValidProperty() throws IOException {
    writeTestPropertyValues(InfoPickerConstants.PROPERTY_CONSUMER_APP, "GeoTracker");
    assertEquals(ConsumerApps.GEOTRACKER, launcher.getApplicationName());
  }

  @Test
  public void checkIfIotServerNameIsReturnedAsDefaultOnNullProperty() throws IOException {
    writeTestPropertyValues(InfoPickerConstants.PROPERTY_IOTSERVER, "");
    assertEquals(IotServer.DEFAULT, launcher.getIotServerName());
  }

  @Test
  public void checkIfIotServerNameIsReturnedAsDefaultOnInvalidProperty() throws IOException {
    writeTestPropertyValues(InfoPickerConstants.PROPERTY_IOTSERVER, "TestServer");
    assertEquals(IotServer.DEFAULT, launcher.getIotServerName());
  }

  @Test
  public void checkIfCorrectIotServerNameIsReturnedOnValidProperty() throws IOException {
    writeTestPropertyValues(InfoPickerConstants.PROPERTY_IOTSERVER, "KAA");
    assertEquals(IotServer.KAA, launcher.getIotServerName());
  }
  
  
  @Test
  public void testWhetherDisplayInformationOfDefaultAppIsInvokedOnStartApp() throws IOException
  {
    GeoLocatorApplication geoLocatorAppMock = Mockito.mock(GeoLocatorApplication.class);
    AppIotPlatformFactory appIotPlatformFactoryMock = Mockito.mock(AppIotPlatformFactory.class);
    writeTestPropertyValues(InfoPickerConstants.PROPERTY_CONSUMER_APP, "GeoLocator");
    writeTestPropertyValues(InfoPickerConstants.PROPERTY_IOTSERVER, "Default");
    Mockito.when(appIotPlatformFactoryMock.getIotInstance(Mockito.any(ConsumerApps.class), Mockito.any(IotServer.class))).thenReturn(geoLocatorAppMock);
    launcher.startApp(appIotPlatformFactoryMock);
    Mockito.verify(geoLocatorAppMock,Mockito.times(1)).displayInformation();
  }

}
