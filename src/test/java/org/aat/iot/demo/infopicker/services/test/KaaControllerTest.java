package org.aat.iot.demo.infopicker.services.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.aat.iot.demo.infopicker.services.KaaController;
import org.junit.Before;
import org.junit.Test;
import org.kaaproject.kaa.client.KaaClient;
import org.kaaproject.kaa.client.event.EventFamilyFactory;
import org.kaaproject.kaa.client.event.registration.UserAttachCallback;
import org.kaaproject.kaa.common.endpoint.gen.SyncResponseResultType;
import org.kaaproject.kaa.common.endpoint.gen.UserAttachResponse;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.sequoia.kaa.poc.infopicker.DeviceInfosRequest;
import org.sequoia.kaa.poc.infopicker.InfoPickerEventClassFamily;



public class KaaControllerTest {

  // Class under test
  private KaaController kaaController;

  @Mock
  private KaaClient kaaClientMock;
  
  @Mock
  private EventFamilyFactory eventFamilyFactoryMock;
  
  @Mock
  private InfoPickerEventClassFamily infoPickerEventClassFamilyMock;
  
  @Mock
  private DeviceInfosRequest deviceInfosRequestMock;


  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    kaaController = new KaaController();
    kaaController.setKaaClient(kaaClientMock);
  }

  @Test
  public void testWhetherIsUserAttachedReturnedTrueOnLoginSuccessful() {

    final UserAttachResponse response = new UserAttachResponse();
    response.setResult(SyncResponseResultType.SUCCESS);

    Mockito.doAnswer(new Answer<Object>() {
      @Override
      public Object answer(InvocationOnMock invocation) throws Throwable {
        ((UserAttachCallback) invocation.getArguments()[2]).onAttachResult(response);
        return null;
      }
    }).when(kaaClientMock).attachUser(Mockito.any(String.class), Mockito.any(String.class),
        Mockito.any(UserAttachCallback.class));

    // The method under test
    kaaController.login("aa", "aa");

    // Verify state and interaction
    Mockito.verify(kaaClientMock, Mockito.times(1)).attachUser(Mockito.any(String.class),
        Mockito.any(String.class), Mockito.any(UserAttachCallback.class));
    assertTrue(kaaController.isUserAttached());
  }

  @Test
  public void testWhetherIsUserAttachedReturnedFalseOnLoginUnSuccessful() {

    final UserAttachResponse response = new UserAttachResponse();
    response.setResult(SyncResponseResultType.FAILURE);

    Mockito.doAnswer(new Answer<Object>() {
      @Override
      public Object answer(InvocationOnMock invocation) throws Throwable {
        ((UserAttachCallback) invocation.getArguments()[2]).onAttachResult(response);
        return null;
      }
    }).when(kaaClientMock).attachUser(Mockito.any(String.class), Mockito.any(String.class),
        Mockito.any(UserAttachCallback.class));

    // The method under test
    kaaController.login("bb", "bb");

    // Verify state and interaction
    Mockito.verify(kaaClientMock, Mockito.times(1)).attachUser(Mockito.any(String.class),
        Mockito.any(String.class), Mockito.any(UserAttachCallback.class));
    assertFalse(kaaController.isUserAttached());
  }
  
  
  
}
