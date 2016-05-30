package org.aat.iot.demo.infopicker.model;

/**
 * <h1>EventData</h1>
 * <p>
 * This is a custom object class, all the data collected by the application is specified as
 * EventData, which an Id, label and value.
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */

public class EventData {

  private int id;
  private String label;
  private String value;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }



}
