package racingcar;

public class Car {
    int position;

    public Car() {
        this.position = 0;
    }

    public int moveForward() {
        this.position++;
        return position;
    }

    public String makePositionShape() {
        return "-".repeat(position);
    }
}
