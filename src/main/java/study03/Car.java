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
    
    public void moveByCondition() {
        Optional.of(createConditionNumber()).filter(cnt -> cnt >= 4).ifPresent(y -> this.position += "-");
    }

    public int createConditionNumber() {
        return new Random().nextInt(10);
    }

    public String getPosition() {
        return position;
    }
}
