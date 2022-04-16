package racingcar;

public class Car {
    private int position;
    public final String name;

    public Car(String name) {
        this.position = 1;
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position += 1;
    }
}
