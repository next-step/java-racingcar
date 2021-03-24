package step3.domain;

import step3.service.GameRule;

public class Car {
    private final String symbol;
    private String score = "";
    private final String name;

    public Car(String name, String scoreSymbol) {
        this.name = name;
        this.symbol = scoreSymbol;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public void move(GameRule rule) {
        if (rule.isMovable()) {
            score += symbol;
        }
    }
}
