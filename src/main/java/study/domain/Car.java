package study.domain;

import study.policy.RacingCarPolicy;
import study.util.RandomNumberGenerator;

public class Car {
    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name.trim();
        this.position = new Position(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void moving(int num) {
        if (RacingCarPolicy.canMovingCar(num)) {
            position.move();
        }
    }

    public boolean matchPosition(int position) {
        return this.position.isSame(position);
    }
}
