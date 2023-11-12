package game.race;

import game.race.support.move.MovePolicy;

public class Car {

    private final String name;
    private int moveCount;
    private final MovePolicy movePolicy;

    public Car(String name, MovePolicy movePolicy) {
        this.name = name;
        this.moveCount = 0;
        this.movePolicy = movePolicy;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    public void move(int number) {
        moveCount+= movePolicy.move(number);
    }
}
