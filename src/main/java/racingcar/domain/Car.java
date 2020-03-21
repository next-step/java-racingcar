package racingcar.domain;

import lombok.Getter;
import racingcar.view.ResultView;

import java.util.Random;

public class Car {
    private final int RANDOM_BOUND = 10;
    private final int ADVANCE_CONDITION = 4;

    private int position;

    public void move() {
        if (advance()) {
            this.position++;
        }
    }

    public void printPosition() {
        ResultView.printPosition(position);
    }

    private boolean advance() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUND) > ADVANCE_CONDITION;
    }
}
