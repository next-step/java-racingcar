package racingcar.domain;

public class Car {
    private static final int BOUNDARY = 4;

    private Engine engine;
    private int position = 0;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomValue = engine.getPower();
        if (isMovable(randomValue)) {
            position++;
        }
    }

    private boolean isMovable(int randomValue) {
        return randomValue >= BOUNDARY;
    }
}
