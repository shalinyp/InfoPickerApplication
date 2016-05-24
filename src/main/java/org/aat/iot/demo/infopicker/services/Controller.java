package org.aat.iot.demo.infopicker.services;

import org.aat.iot.demo.infopicker.model.EventData;

/**
 * <h1>Controller</h1> 
 * <p> This interface exposes all the method required for the interaction with an Iot server.
 * </p>
 * 
 * @author Shalini
 * @version 1.0
 * @since 5/13/2016
 */
@FunctionalInterface
public interface Controller 
{
  public EventData getInformation();
}
