package org.aat.iot.demo.infopicker.geotracker;

import org.aat.iot.demo.infopicker.ConsumerApplication;
import org.aat.iot.demo.infopicker.services.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>GeoTrackerApplication</h1> 
 * <p>GeoTrackerApplication is a specific Consumer Application which returns GPS location
 * as latitude and longitude.
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */

public class GeoTrackerApplication extends ConsumerApplication {
  
  private static final Logger LOG = LoggerFactory.getLogger(GeoTrackerApplication.class);

  Controller mIotController;
  
  public GeoTrackerApplication(Controller iotPlatform) {
    mIotController = iotPlatform;
  }

  public void displayInformation() {
    LOG.debug("GeoTracker Application");
  }

}
