package study.racing.model.car;

import study.racing.model.rule.Rule;

public class Car {

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrStop(Rule rule) {
        if (rule.isFollowRule()) {
            move();
        }
    }

    private void move() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }
}
