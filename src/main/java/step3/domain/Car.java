package step3.domain;

import step3.service.GameRule;

public class Car {
    private final String symbol;
    private String score = "";

    public Car(String scoreSymbol) {
        this.symbol = scoreSymbol;
    }

    public String getScore() {
        return score;
    }

    public void move(GameRule rule) {
        if (rule.isMovable()) {
            score += symbol;
        }
    }

    public void moveTest(GameRule rule, int num) {
        if (rule.isMovableTest(num)) {
            score += symbol;
        }
    }
}
