package racingcar;

public class Car {
    private int position = 0;

    public Car() {}

    public void forward() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }
}
