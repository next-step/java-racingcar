package step3.domain;

import step3.utils.GameRule;

public class Car {
    private int score = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void move(GameRule rule) {
        if (rule.isMovable()) {
            score += 1;
        }
    }
}
