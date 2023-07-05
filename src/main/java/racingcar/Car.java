package racingcar;

import java.text.MessageFormat;

public class Car {

    public static final String DASH = "-";

    public int moveCount;
    public String name;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String statusToString() {
        return MessageFormat.format("{0} : {1}", name, DASH.repeat(moveCount));
    }

    public void move(int random) {
        if (random >= 4) {
            this.moveCount++;
        }
    }
}
