package racingcar;

import racingcar.ui.RacingCarResult;

public class RacingCar implements Comparable<RacingCar> {
    private int distance;
    private final RacingCarName carName;

    public RacingCar(RacingCarName carName) {
        this.carName = carName;
    }

    public void moveIfMovable(RacingCarMoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            move();
        }
    }

    public void moveIfMovable(RacingCarMoveStrategy moveStrategy, int times) {
        for (int i = 0; i < times; i++) {
            moveIfMovable(moveStrategy);
        }
    }

    private void move() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(o.distance, distance);
    }

    public RacingCarResult toResult() {
        return new RacingCarResult(carName.toString(), distance);
    }
}
