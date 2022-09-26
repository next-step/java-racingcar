package racing.domain;

import racing.rule.Rule;

public class GameSet {

    private final Rule rule;

    private int numberOfCars = 0;
    private int numberOfMove = 0;

    public GameSet(Rule rule) {
        if (rule == null) {
            throw new IllegalArgumentException("설정된 게임 규칙이 올바르지 않습니다.");
        }
        this.rule = rule;
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }

    public void setNumberOfMove(int numberOfMove) {
        if (numberOfMove < 1) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
        this.numberOfMove = numberOfMove;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        if (numberOfCars < 1) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
        this.numberOfCars = numberOfCars;
    }

    public Rule getRule() {
        return rule;
    }
}
