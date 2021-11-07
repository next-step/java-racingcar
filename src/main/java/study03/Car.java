package study03;

import java.util.Optional;
import java.util.Random;

/*
 *
 * Car
 *
 * @version 1.0.0
 *
 * 2021-11-07
 *
 * Copyright tnals1422
 */
public class Car {

    private String position = "";

    public String moveByCondition() {
        return Optional.of(createConditionNumber()).filter(cnt -> cnt >= 4).map(i -> "-").orElseGet(() -> null);
    }

    public int createConditionNumber() {
        return new Random().nextInt(10);
    }

    public void moveForward(String position) {
        this.position += position;
    }

    public String getPosition() {
        return position;
    }
}
