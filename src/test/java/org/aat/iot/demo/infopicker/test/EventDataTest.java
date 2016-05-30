package org.aat.iot.demo.infopicker.test;

import static org.junit.Assert.assertEquals;

import org.aat.iot.demo.infopicker.model.EventData;
import org.junit.Before;
import org.junit.Test;

public class EventDataTest {

  // Class under Test
  EventData data;

  @Before
  public void setUp() {
    data = new EventData();
  }

  @Test
  public void testEventDataMethods() {
    data.setId(1);
    data.setLabel("TestLabel");
    data.setValue("TestValue");
    assertEquals(1, data.getId());
    assertEquals("TestLabel", data.getLabel());
    assertEquals("TestValue", data.getValue());
  }

}
