package org.aat.iot.demo.infopicker.test;

import static org.junit.Assert.*;

import org.aat.iot.demo.infopicker.utils.Utility;
import org.junit.Test;


//Class under test - Utility
public class UtilityTest {  
  
  public enum TestEnum{    
    TEST1,TEST2;
  }
 
  
  @Test
  public void testIfisInEnumReturnsTrueIfEnumFound()
  {    
    assertTrue(Utility.isInEnum("TEST1", TestEnum.class));
  }
  
  @Test
  public void testIfisInEnumReturnsFalseIfEnumNotFound()
  {
    assertFalse(Utility.isInEnum("TEST3", TestEnum.class));
  }
  

}
