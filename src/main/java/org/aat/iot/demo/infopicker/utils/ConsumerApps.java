package org.aat.iot.demo.infopicker.utils;

/**
 * <h1>ConsumerApps</h1> 
 * <p> This enum class provides values for different types of Consumer Apps
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */

public enum ConsumerApps {

  GEOTRACKER("GeoTracker"),GEOLOCATOR("GeoLocator"), DEFAULT("Default");

  private String mAppName;

  ConsumerApps(String appName) {
    mAppName = appName;
  }
}
