package com.mommoo.step2;

public class Car {
    private final String name;
    private final int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car nextPositionCar() {
        int nextPosition = this.position + 1;
        return new Car(this.name, nextPosition);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isCarInstance = obj instanceof Car;

        if (!isCarInstance) {
            return false;
        }

        Car car = (Car) obj;
        String targetCarName = car.name;
        int targetPosition = car.position;

        return targetCarName.equals(this.name) && targetPosition == this.position;
    }
}
