package org.aat.iot.demo.infopicker.test;

import org.aat.iot.demo.infopicker.AppIotPlatformFactory;
import org.aat.iot.demo.infopicker.ConsumerApplication;
import org.aat.iot.demo.infopicker.utils.ConsumerApps;
import org.aat.iot.demo.infopicker.utils.IotServer;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Shalini on 5/16/2016.
 */
public class GeoTrackerApplicationTest {

  // class under Test
  @Before
  public void setUp() {
    AppIotPlatformFactory appIotPlatformFactory = new AppIotPlatformFactory();
    ConsumerApplication consumerApplication =
        appIotPlatformFactory.getIotInstance(ConsumerApps.GEOTRACKER, IotServer.DEFAULT);
  }

  @Test
  public void testInvalidUrlReturnsException() {

  }


}
