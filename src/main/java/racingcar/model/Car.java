package racingcar.model;

import java.util.Random;

public class Car {
    private static final int BOUND = 10;
    private static final int GO_CONDITION = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private int score;
    private String name;

    Car(String name) {
        if (isValidName(name)) {
            this.name = name;
            score = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    private void go() {
        score++;
    }

    void attempt() {
        if (isAbleToMove()) {
            this.go();
        }
    }

    private boolean isAbleToMove() {
        Random random = new java.util.Random();
        return random.nextInt(BOUND) > GO_CONDITION;
    }

    private boolean isValidName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
