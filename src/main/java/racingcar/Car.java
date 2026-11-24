package racingcar;

public class Car {
    private int position = 0;
    private final String name;

    public Car() {
        this("");
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
