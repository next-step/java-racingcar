package racingcar.domain;

public class Car {
    private int point = 0;

    public void move(RandomNumberGenerator generator) {
        if (generator.isMovable()) {
            this.point += 1;
        }
    }

    public int getPoint() {
        return this.point;
    }

    public int findCarPoint() {
        return point;
    }
}
