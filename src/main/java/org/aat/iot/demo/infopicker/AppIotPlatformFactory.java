package org.aat.iot.demo.infopicker;


import org.aat.iot.demo.infopicker.defaultapplication.DefaultApplication;
import org.aat.iot.demo.infopicker.defaultapplication.GeoLocatorApplication;
import org.aat.iot.demo.infopicker.geotracker.GeoTrackerApplication;
import org.aat.iot.demo.infopicker.services.GeoLocatorController;
import org.aat.iot.demo.infopicker.services.KaaController;
import org.aat.iot.demo.infopicker.utils.ConsumerApps;
import org.aat.iot.demo.infopicker.utils.IotServer;

/**
 * <h1>AppIotPlatformFactory</h1>
 * <p>
 * This is a factory class for creating specific ConsumerApplication based on the consumer app and
 * iot server argument.
 * </p>
 * 
 * @author aat@
 * @version 1.0
 * @since 5/13/2016
 */

public class AppIotPlatformFactory {

  /**
   * This method is used to create an instance of ConsumerApplication based on the consumerApps and
   * iotServer. The default application instance is return on default conditions
   * 
   * @param consumerApps.
   * @param iotServer.
   * @return an instance of the requested ConsumerApplication.
   * @exception NullPointerException on null args.
   * @see NullPointerException
   */

  public ConsumerApplication getIotInstance(ConsumerApps consumerApps, IotServer iotServer) {

    if (consumerApps.equals(ConsumerApps.GEOTRACKER) && iotServer.equals(IotServer.KAA)) {
      return new GeoTrackerApplication(new KaaController());
    } else if (consumerApps.equals(ConsumerApps.GEOLOCATOR)
        && iotServer.equals(IotServer.DEFAULT)) {
      return new GeoLocatorApplication(new GeoLocatorController());
    }
    return new DefaultApplication(null);
  }
}
