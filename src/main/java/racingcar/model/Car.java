package racingcar.model;

public class Car {
    private int distance = 0;

    public int getDistance() {
        return distance;
    }

    public void move(boolean isMove) {
        if(isMove) {
            distance += 1;
        }
    }
}
