package racingcar;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Car names cannot exceed 5 characters");
        }
        this.position = position;
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
