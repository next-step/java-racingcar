package racingcar.domain;

public class Car {

    private final int MORE_THEN_CONDITION_NUMBER = 4;
    private final String name;
    private int position;

    public Car() {
        this("unknown", 0);
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.position = position;
        this.name = name;
    }

    public void move() {
        position++;
    }

    public void move(int bound) {
        if (bound >= MORE_THEN_CONDITION_NUMBER) {
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
