package step3.domain;

import step3.service.GameMatcher;

public class Car {

    private final GameMatcher matcher;

    private int distance;

    public Car(GameMatcher matcher) {
        this.matcher = matcher;
        this.distance = 0;
    }

    public int getCarDistance() {
        return this.distance;
    }

    public void forward(int random) {
        if (matcher.match(random)) {
            this.distance++;
        }
    }
}
