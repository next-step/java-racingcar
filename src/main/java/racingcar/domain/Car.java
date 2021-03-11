package racingcar.domain;

public class Car {
    private static final int BOUNDARY = 4;

    private Engine engine;
    private int position = 0;
    private Name name;

    public Car(Engine engine, String name) {
        this.engine = engine;
        this.name = new Name(name);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.value();
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
