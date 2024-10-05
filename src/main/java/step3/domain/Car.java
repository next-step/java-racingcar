package step3.domain;

import step3.service.CarEngine;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = Position.zeroPosition();
    }

    public void move(CarEngine carEngine) {
        if (carEngine.canGetPower()) {
            position.forwardOnce();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isWinner(int maxScore) {
        return maxScore == getPosition();
    }
}
