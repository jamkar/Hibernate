package org.javabrains.dto;

import javax.persistence.Entity;

/**
 * Created by Karen on 09-Jul-17.
 */

@Entity
//@DiscriminatorValue("Bike")
public class TwoWheelVehicle extends Vehicle {

    private String steeringHandle;

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
}
