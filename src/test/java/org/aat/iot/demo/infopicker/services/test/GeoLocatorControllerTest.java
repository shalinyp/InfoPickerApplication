package org.aat.iot.demo.infopicker.services.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.nio.file.Files;

import org.aat.iot.demo.infopicker.AppIotPlatformFactory;
import org.aat.iot.demo.infopicker.services.GeoLocatorController;
import org.aat.iot.demo.infopicker.test.TestConstants;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

public class GeoLocatorControllerTest {
  //Class under Test
  AppIotPlatformFactory appIotFactory = new AppIotPlatformFactory();
  GeoLocatorController geoLocatorController;

  
  @Before
  public void setUp()
  {   
    geoLocatorController = new GeoLocatorController();
  }
  
  @Test
  public void testWhetherCorrectMapSizeIsReturnOnRightParameters() throws IOException{

    FileInputStream output = new FileInputStream("src\\test\\resources\\staticmap.png");
    byte[] imageBytes = IOUtils.toByteArray(output);
    byte[] mapBytes = geoLocatorController.getMap(TestConstants.GOOGLE_MAP_URL,"Australia");
    assertEquals(imageBytes.length,mapBytes.length);
    
  }
  
  @Test(expected = UnknownHostException.class)
  public void testWhetherUnknownHostExceptionIsThrownOnInvalidUrl() throws UnknownHostException  {
      try {
        geoLocatorController.getMap("http://ms.testdummy.dummy/map/api/staticmap?center=","Australia");
      } catch (IOException e) {
          throw new UnknownHostException();
      }
    
  }

}
