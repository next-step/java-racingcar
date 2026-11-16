package racingcar;

public class Car {

    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
