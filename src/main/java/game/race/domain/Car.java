package game.race.domain;

import game.race.domain.support.move.MovePolicy;

public class Car {

    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    public void move(MovePolicy policy) {
        moveCount = policy.move() ? moveCount + 1 : moveCount;
    }
}
