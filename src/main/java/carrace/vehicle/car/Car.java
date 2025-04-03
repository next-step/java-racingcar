package carrace.vehicle.car;

import carrace.common.Vehicle;
import carrace.movement.car.CarMovement;

public class Car implements Vehicle {

    public static final String IDENTIFIER = "CAR";
    private CarMovement carMovement;

    private final String name;

    public Car(String name, CarMovement carPosition) {
        this.name = name;
        this.carMovement = carPosition;
    }

    @Override
    public String identifier() {
        return IDENTIFIER;
    }

    // 상하좌우가 추가 될 경우 맞춰 if 조건 추가
    @Override
    public void move(int randomValue) {
        carMovement.checkAndMoveForward(randomValue);
    }

    public String getCurrentPosition() {
        return carMovement.get();
    }

    public String getCarName() {
        return name;
    }
}
