package racingcar;

public class Car {

    private int distance = 0;

    public void move(boolean isMove) {
        if (isMove) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
