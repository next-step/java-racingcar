package racingcar;

public class Car {
    private int position = 0;

    public Car() {}

    public Car(int position) {
        this.position = position;
    }

    public void forward() {
        position += 1;
    }

    public String getPositionString() {
        return "-".repeat(position);
    }

    public int getPosition() {
        return position;
    }
}
