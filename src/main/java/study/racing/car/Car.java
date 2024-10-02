package study.racing.car;

public class Car {

    private int position;
    private final String name;
    private static final int START_POSITION = 0;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void move() {
        this.position++;
    }

    public int getCurrentPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
