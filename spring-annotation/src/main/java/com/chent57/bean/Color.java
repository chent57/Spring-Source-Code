package com.chent57.bean;

public class Color {
    private Car car;

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
