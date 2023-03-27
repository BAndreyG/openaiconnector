package org.openaiconnector.beans;

public abstract class BaseRequest implements Bean {
    private String model;
    private double temperature;

    public BaseRequest(String model, double temperature) {
        this.model = model;
        this.temperature = temperature;
    }

    public String getModel() {
        return model;
    }

    public double getTemperature() {
        return temperature;
    }
}
