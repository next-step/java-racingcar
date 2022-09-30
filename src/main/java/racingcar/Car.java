package racingcar;

public class Car {
    private int position = 0;

    public void forward() {
        position += 1;
    }

    public String getPositionString() {
        return "-".repeat(position);
    }
}
