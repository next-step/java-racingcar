package racingcar;

import java.security.InvalidParameterException;

public class Car {

    public static final int MOVE_LIMIT = 4;
    private final String name;
    private int distance = 1;

    public Car(String name) {
        carNameValidation(name);
        this.name = name;
    }

    private void carNameValidation(String name) {
        if(name.length() > 5){
            throw new InvalidParameterException("자동차의 이름은 5이하만 가능합니다.");
        }
    }

    public void move() {
        this.distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    public boolean moveable(int value) {
        return value >= MOVE_LIMIT;
    }

    public String getName() {
        return this.name;
    }
}
