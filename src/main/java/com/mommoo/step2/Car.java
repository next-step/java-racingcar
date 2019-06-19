package com.mommoo.step2;

public class Car {
    private final String NAME;
    private final int POSITION;

    public Car(String name, int position) {
        this.NAME = name;
        this.POSITION = position;
    }

    public Car nextPositionCar() {
        int nextPosition = this.POSITION + 1;
        return new Car(this.NAME, nextPosition);
    }

    public String getName() {
        return NAME;
    }

    public int getPosition() {
        return POSITION;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isCarInstance = obj instanceof Car;

        if (!isCarInstance) {
            return false;
        }

        Car car = (Car) obj;
        String targetCarName = car.getName();
        int targetPosition = car.getPosition();

        return targetCarName.equals(getName()) && targetPosition == getPosition();
    }
}
