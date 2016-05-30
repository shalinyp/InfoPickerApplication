package org.aat.iot.demo.infopicker.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.aat.iot.demo.infopicker.InfoPickerApplication;
import org.aat.iot.demo.infopicker.InfoPickerLauncher;
import org.aat.iot.demo.infopicker.utils.InfoPickerConstants;
import org.junit.Test;
import org.mockito.Mockito;


/**
 * Created by Shalini on 5/16/2016.
 */
public class InfoPickerApplicationTest {

  @Test
  public void checkWhetherMainMethodCallsTheLauncher() throws IOException {
    InfoPickerLauncher launcherMock = Mockito.mock(InfoPickerLauncher.class);
    InfoPickerApplication.setLauncher(launcherMock);
    InfoPickerApplication.main(new String[] {"test1", "test2"});
    // PowerMockito.verifyNew(InfoPickerLauncher.class).withNoArguments();
    Mockito.verify(launcherMock).loadPropertyFile(InfoPickerConstants.PROPERTY_FILE);
  }

  @Test
  public void checkWhetherGetInstanceReturnsInfoPickerApplicationInstance() {
    assertTrue(InfoPickerApplication.getInstance() instanceof InfoPickerApplication);
  }



}
