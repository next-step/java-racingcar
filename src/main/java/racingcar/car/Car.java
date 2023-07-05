package racingcar.car;

import java.text.MessageFormat;

public class Car {

    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
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
