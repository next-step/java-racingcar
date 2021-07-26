package racingcar.model;

import java.util.Random;

public class Car {
    private static final int BOUND = 10;
    private static final int GO_CONDITION = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private int score;
    private String name;

    Car(String name) {
        checkNameValidation(name);
        this.name = name;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    void go(int number) {
        if (number > GO_CONDITION) {
            score++;
        }
    }

    private void checkNameValidation(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
