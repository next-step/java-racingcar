package racingcar.car;

import racingcar.Position;

public class NextStepCar implements Car {
    private final String name;
    private Position position;

    public Position getPosition() {
        return position;
    }

    public NextStepCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name length must be lower than 5");
        }
        this.name = carName;
        this.position = new Position();
    }

    @Override
    public int moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            position.moveForward();
        }
        return position.getPosition();
    }

    @Override
    public String getName() {
        return name;
    }
}
