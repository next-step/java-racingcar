package com.mommoo.step2;

import com.mommoo.step2.domain.CarMovingConditioner;

public class Car {
    private static final int MOVE_ONE_POSITION = 1;

    private final String name;
    private final int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car nextCar(CarMovingConditioner carMovingConditioner) {
        int nextPosition = carMovingConditioner.canMove() ? position + MOVE_ONE_POSITION : position;
        return new Car(this.name, nextPosition);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isPositionAt(int position) {
        return this.position == position;
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

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
