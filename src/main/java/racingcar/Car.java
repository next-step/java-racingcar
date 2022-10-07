package racingcar;

public class Car {

    private static final int AVAILABLE_MOVE_BOUND = 4;

    private String name;
    private int position;

    private Car() {}

    public Car(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

    public void move(int number) {
        if (number >= AVAILABLE_MOVE_BOUND) {
            this.position += 1;
        }
    }
}
