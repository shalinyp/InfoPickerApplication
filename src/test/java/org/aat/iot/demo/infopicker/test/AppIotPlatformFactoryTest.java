package org.aat.iot.demo.infopicker.test;

import static org.junit.Assert.assertTrue;

import org.aat.iot.demo.infopicker.AppIotPlatformFactory;
import org.aat.iot.demo.infopicker.ConsumerApplication;
import org.aat.iot.demo.infopicker.defaultapplication.DefaultApplication;
import org.aat.iot.demo.infopicker.geolocator.GeoLocatorApplication;
import org.aat.iot.demo.infopicker.geotracker.GeoTrackerApplication;
import org.aat.iot.demo.infopicker.utils.ConsumerApps;
import org.aat.iot.demo.infopicker.utils.IotServer;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Shalini on 5/13/2016.
 */
public class AppIotPlatformFactoryTest {


  @BeforeClass
  public static void setUp() {

  }

  @Test
  public void checkIfGetInstanceReturnsDefaulAppInstanceOnDefaultArg() {
    AppIotPlatformFactory appIotPlatformFactory = new AppIotPlatformFactory();
    ConsumerApplication consumerApplication =
        appIotPlatformFactory.getIotInstance(ConsumerApps.DEFAULT, IotServer.DEFAULT);
    assertTrue(consumerApplication instanceof ConsumerApplication);
    assertTrue(consumerApplication instanceof DefaultApplication);

  }

  @Test(expected = NullPointerException.class)
  public void checkIfGetInstanceReturnsDefaultAppInstanceOnNullArgs() {
    AppIotPlatformFactory appIotPlatformFactory = new AppIotPlatformFactory();
    ConsumerApplication consumerApplication = appIotPlatformFactory.getIotInstance(null, null);
    assertTrue(consumerApplication instanceof ConsumerApplication);
    assertTrue(consumerApplication instanceof DefaultApplication);

  }

  @Test
  public void checkIfGetInstanceReturnsGeoLocatorAppInstanceValidArgs() {
    AppIotPlatformFactory appIotPlatformFactory = new AppIotPlatformFactory();
    ConsumerApplication consumerApplication =
        appIotPlatformFactory.getIotInstance(ConsumerApps.GEOLOCATOR, IotServer.DEFAULT);
    assertTrue(consumerApplication instanceof ConsumerApplication);
    assertTrue(consumerApplication instanceof GeoLocatorApplication);

  }

  @Test
  public void checkIfGetInstanceReturnsGeoTrackerAppInstanceValidArgs() {
    AppIotPlatformFactory appIotPlatformFactory = new AppIotPlatformFactory();
    ConsumerApplication consumerApplication =
        appIotPlatformFactory.getIotInstance(ConsumerApps.GEOTRACKER, IotServer.KAA);
    assertTrue(consumerApplication instanceof ConsumerApplication);
    assertTrue(consumerApplication instanceof GeoTrackerApplication);

  }
}
