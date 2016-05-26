package org.aat.iot.demo.infopicker.services.test;

import java.io.IOException;
import java.net.UnknownHostException;

import org.aat.iot.demo.infopicker.AppIotPlatformFactory;
import org.aat.iot.demo.infopicker.model.EventData;
import org.aat.iot.demo.infopicker.services.GeoLocatorController;
import org.aat.iot.demo.infopicker.test.TestConstants;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class GeoLocatorControllerTest {
  // Class under Test
  AppIotPlatformFactory appIotFactory = new AppIotPlatformFactory();
  GeoLocatorController geoLocatorController;


  @Before
  public void setUp() {
    geoLocatorController = new GeoLocatorController();
  }

  @Test
  public void testWhetherValidMapIsReturnOnRightParameters() throws IOException {

    // FileInputStream output = new FileInputStream("src\\test\\resources\\staticmap.png");
    // byte[] imageBytes = IOUtils.toByteArray(output);
    byte[] mapBytes = geoLocatorController.getMap(TestConstants.GOOGLE_MAP_URL, "Australia");
    assertTrue(mapBytes.length > 0);

  }

  @Test(expected = UnknownHostException.class)
  public void testWhetherUnknownHostExceptionIsThrownOnInvalidUrl() throws UnknownHostException {
    try {
      geoLocatorController.getMap("http://ms.testdummy.dummy/map/api/staticmap?center=",
          "Australia");
    } catch (IOException e) {
      throw new UnknownHostException();
    }

  }

  @Test
  public void testWhetherGetInformationReturnsEventData() {
    assertTrue(geoLocatorController.getInformation() instanceof EventData);
  }

}
