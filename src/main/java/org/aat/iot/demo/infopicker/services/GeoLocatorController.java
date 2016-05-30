package org.aat.iot.demo.infopicker.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import org.aat.iot.demo.infopicker.model.EventData;

/**
 * GeoLocatorController is a controller for the application GeoLocation. This controller uses
 * GoogleMap API to fetch a static google map image corresponding to the location given.
 */

public class GeoLocatorController implements DefaultController {
  EventData eventData = new EventData();

  @Override
  public EventData getInformation() {
    return eventData;
  }

  /**
   * Fetches a static google map image corresponding to the location given using GoogleMap API
   * returns the image as byte array
   * 
   * @param googleMapUrl
   * @param location
   * @return static google map image byte aaray
   * @throws IOException
   */

  public byte[] getMap(String googleMapUrl, String location) throws IOException {
    URLConnection con =
        new URL(googleMapUrl + "center=" + location + "&size=640x400").openConnection();
    InputStream is = con.getInputStream();
    byte[] bytes = new byte[con.getContentLength() + 1];
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    int nRead;
    while ((nRead = is.read(bytes, 0, bytes.length)) != -1) {
      buffer.write(bytes, 0, nRead);
    }
    buffer.flush();
    is.close();
    eventData.setId(1);
    eventData.setLabel("Map" + location);
    eventData.setValue(Arrays.toString(bytes));
    return bytes;
  }

}
