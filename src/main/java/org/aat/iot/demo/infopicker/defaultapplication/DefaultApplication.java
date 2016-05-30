package org.aat.iot.demo.infopicker.defaultapplication;

import org.aat.iot.demo.infopicker.ConsumerApplication;
import org.aat.iot.demo.infopicker.services.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>DefaultApplication</h1>
 * <p>
 * If no other applications are specified. DefaultApplication application is called on every default
 * conditions.
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */
public class DefaultApplication extends ConsumerApplication {

  private static final Logger LOG = LoggerFactory.getLogger(DefaultApplication.class);

  Controller mIotPlatform;

  public DefaultApplication(Controller iotPlatform) {


    mIotPlatform = iotPlatform;
  }

  public void displayInformation() {
    LOG.debug("Default Application");
    throw new UnsupportedOperationException();
  }



}
