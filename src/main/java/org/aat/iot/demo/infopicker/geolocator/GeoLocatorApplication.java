package org.aat.iot.demo.infopicker.geolocator;

import org.aat.iot.demo.infopicker.ConsumerApplication;
import org.aat.iot.demo.infopicker.services.Controller;
import org.aat.iot.demo.infopicker.services.GeoLocatorController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>GeoLocatorApplication</h1>
 * <p>
 * GeoTrackerApplication is a specific Consumer Application which returns the static google map
 * Image if the location is given.
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */

public class GeoLocatorApplication extends ConsumerApplication {

  private static final Logger LOG = LoggerFactory.getLogger(GeoLocatorApplication.class);

  Controller mIotController;


  public GeoLocatorApplication(GeoLocatorController geoLocatorController) {
    mIotController = geoLocatorController;
  }

  public void displayInformation() {
    LOG.debug("GeoLocator Application");
    mIotController.getInformation();

  }

}
