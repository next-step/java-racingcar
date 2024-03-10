package racingcar;

public class Car {
    private int distance = 1;

    public int getDistance() {
        return this.distance;
    }

    public void move(int data) {
        if (data >= 4) {
            distance += 1;
        }
    }
}
