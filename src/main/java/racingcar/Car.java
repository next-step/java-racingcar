package racingcar;

import java.text.MessageFormat;
import java.util.Arrays;

public class Car {

    public int moveCount =0;
    public String name;

    public Car(String name) {
        this.name = name;
    }

    public String statusToString() {
        return MessageFormat.format("{0} : {1}", name, "-".repeat(moveCount));
    }

    public void move(int random) {
        if (random >= 4) {
            this.moveCount++;
        }
    }
}
