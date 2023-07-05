package racingcar;

import java.text.MessageFormat;
import java.util.Arrays;

public class Car {

    public int moveCount =0;
    public String name;

    public Car(String name) {
        this.name = name;
    }

    private int generateRandom() {
        return (int) (Math.random() * 10000) % 10;
    }

    public String statusToString() {
        return MessageFormat.format("{0} : {1}", name, "-".repeat(moveCount));
    }

    public void move() {
        if (generateRandom() >= 4) {
            this.moveCount++;
        }
    }
}
