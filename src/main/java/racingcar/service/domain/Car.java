package racingcar.service.domain;

import racingcar.service.strategy.Rule;

public class Car {
    private int id;
    private int position;

    public Car(int id) {
        this.id = id;
    }

    public void move(Rule rule) {
        if (rule.checkCondition())
            position++;
    }

    public int getPosition() {
        return position;
    }

    public String toString() {
        return String.format("id : %d, position : %d", id, position);
    }
}