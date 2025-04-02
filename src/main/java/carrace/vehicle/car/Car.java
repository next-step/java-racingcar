package carrace.vehicle.car;

import carrace.common.Vehicle;
import carrace.movement.car.CarMovement;

public class Car implements Vehicle {

    private static final int MOVE_CONDITION = 4;
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

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
        if (randomValue < LOWER_BOUND || randomValue > UPPER_BOUND) {
            throw new RuntimeException("랜덤 값은 0에서 9사이의 값이어야합니다.");
        }

        if (randomValue >= MOVE_CONDITION) {
            carMovement.moveForward();
        }
    }

    public String getCurrentPosition() {
        return carMovement.get();
    }

    public String getCarName() {
        return name;
    }
}
