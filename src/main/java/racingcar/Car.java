package racingcar;

public class Car {
    private int position;
    public final String name;

    public Car(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("Car name size should between 1 and 5");
        }
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
