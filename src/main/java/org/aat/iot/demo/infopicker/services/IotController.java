package org.aat.iot.demo.infopicker.services;

import org.aat.iot.demo.infopicker.model.EventData;

public interface IotController extends Controller{
  
  public boolean initialize();
  
  public void login(String username, String password);

  public EventData retrieveDataFromServer();

}
