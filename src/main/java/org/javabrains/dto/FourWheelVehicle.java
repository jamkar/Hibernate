package org.javabrains.dto;

import javax.persistence.Entity;

/**
 *
 */

@Entity
//@DiscriminatorValue("Car")
public class FourWheelVehicle extends Vehicle {

    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
