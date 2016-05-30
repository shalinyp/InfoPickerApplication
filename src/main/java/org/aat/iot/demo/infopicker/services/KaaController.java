package org.aat.iot.demo.infopicker.services;


import org.aat.iot.demo.infopicker.model.EventData;
import org.kaaproject.kaa.client.DesktopKaaPlatformContext;
import org.kaaproject.kaa.client.Kaa;
import org.kaaproject.kaa.client.KaaClient;
import org.kaaproject.kaa.client.KaaClientPlatformContext;
import org.kaaproject.kaa.client.SimpleKaaClientStateListener;
import org.kaaproject.kaa.client.event.registration.UserAttachCallback;
import org.kaaproject.kaa.client.exceptions.KaaException;
import org.kaaproject.kaa.common.endpoint.gen.SyncResponseResultType;
import org.kaaproject.kaa.common.endpoint.gen.UserAttachResponse;

public class KaaController implements IotController, UserAttachCallback {


  KaaClient kaaClient;
  boolean isKaaStarted;
  private boolean mUserAttached = false;
  EventData eventData = new EventData();


  public boolean isKaaStarted() {
    return isKaaStarted;
  }

  public KaaClientPlatformContext getKaaContext() {
    return new DesktopKaaPlatformContext();
  }

  @Override
  public EventData getInformation() {
    return eventData;
  }

  @Override
  public void login(String username, String password) {
    kaaClient.attachUser(username, password, this);
  }

  /*
   * Receive the result of the endpoint attach operation. Notify remote devices about availability
   * in case of success.
   */
  @Override
  public void onAttachResult(UserAttachResponse response) {
    SyncResponseResultType result = response.getResult();
    if (result == SyncResponseResultType.SUCCESS) {
      mUserAttached = true;
    } else {
      mUserAttached = false;

    }
  }

  public boolean isUserAttached() {
    return mUserAttached;
  }

  public void setKaaClient(KaaClient kaaClient) {
    this.kaaClient = kaaClient;
  }

  @Override
  public boolean initialize() {
    isKaaStarted = false;

    KaaClientPlatformContext kaaClientContext = getKaaContext();
    kaaClient = Kaa.newClient(kaaClientContext, new SimpleKaaClientStateListener() {
      @Override
      public void onStarted() {
        isKaaStarted = true;

      }

      @Override
      public void onStartFailure(KaaException exception) {
        isKaaStarted = false;
      }
    });
    if (isKaaStarted)
      kaaClient.start();
    setKaaClient(kaaClient);
    return isKaaStarted;
  }

  @Override
  public EventData retrieveDataFromServer() {
    return eventData;
  }

}
