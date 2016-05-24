package org.aat.iot.demo.infopicker.utils;

/**
 * <h1>IotServer</h1> 
 * <p> This enum class provides values for different types of Iot platform
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */

public enum IotServer {

  KAA("Kaa"), KII("Kii"), DEFAULT("Default");

  private String mIotServer;

  IotServer(String iotServer) {
    mIotServer = iotServer;
  }

}
