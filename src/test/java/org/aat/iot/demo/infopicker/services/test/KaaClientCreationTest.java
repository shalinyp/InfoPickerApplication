package org.aat.iot.demo.infopicker.services.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kaaproject.kaa.client.Kaa;
import org.kaaproject.kaa.client.KaaClient;
import org.kaaproject.kaa.client.KaaClientPlatformContext;
import org.kaaproject.kaa.client.SimpleKaaClientStateListener;
import org.kaaproject.kaa.client.exceptions.KaaException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.aat.iot.demo.infopicker.services.KaaController;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Kaa.class)
public class KaaClientCreationTest {
  // Class under test
  private KaaController kaaController;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @Mock
  public KaaClient kaaClientMock;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    kaaController = new KaaController();
  }

  @Test
  public void testWhetherIsKaaStartedFuncReturnsTrueOnInitializing() {
    mockStatic(Kaa.class);
    PowerMockito.doAnswer(new Answer<KaaClient>() {
      @Override
      public KaaClient answer(InvocationOnMock invocation) throws Throwable {
        ((SimpleKaaClientStateListener) invocation.getArguments()[1]).onStarted();
        return kaaClientMock;
      }
    }).when(Kaa.class);
    Kaa.newClient(Mockito.any(KaaClientPlatformContext.class),
        Mockito.any(SimpleKaaClientStateListener.class));
    kaaController.initialize();
    assertTrue(kaaController.isKaaStarted());

  }

  @Test
  public void testWhetherIsKaaStartedFuncReturnsFalseIfNotInitialized() {
    mockStatic(Kaa.class);
    PowerMockito.doAnswer(new Answer<KaaClient>() {
      @Override
      public KaaClient answer(InvocationOnMock invocation) throws Throwable {
        ((SimpleKaaClientStateListener) invocation.getArguments()[1])
            .onStartFailure(Mockito.any(KaaException.class));
        return null;
      }
    }).when(Kaa.class);
    Kaa.newClient(Mockito.any(KaaClientPlatformContext.class),
        Mockito.any(SimpleKaaClientStateListener.class));
    kaaController.initialize();
    assertFalse(kaaController.isKaaStarted());

  }

}
