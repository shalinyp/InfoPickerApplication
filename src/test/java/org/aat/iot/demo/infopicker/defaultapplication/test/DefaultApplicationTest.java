package org.aat.iot.demo.infopicker.defaultapplication.test;

import org.aat.iot.demo.infopicker.defaultapplication.DefaultApplication;
import org.junit.Test;

public class DefaultApplicationTest {

  // Class under test
  DefaultApplication defaultApp = new DefaultApplication(null);

  @Test(expected = UnsupportedOperationException.class)
  public void testDisplayInformationThrowsUnsupportedOperationEx() {
    defaultApp.displayInformation();
  }

}
