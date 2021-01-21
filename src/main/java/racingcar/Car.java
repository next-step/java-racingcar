package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void updatePosition() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }
}
