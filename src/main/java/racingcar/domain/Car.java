package racingcar.domain;

public class Car {

    private Engine engine;
    private final String name;
    private int moveCount = 0;

    public Car(Engine engine, String name) {
        this.name = name;
    }

    public void moveAndStop() {
        moveCount += engine.move();
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}