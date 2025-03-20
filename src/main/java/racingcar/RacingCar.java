package racingcar;

public class RacingCar implements Comparable<RacingCar> {

    private static final String MOVE_SYMBOL = "-";
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

    public RacingCarName getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(o.distance, distance);
    }

    @Override
    public String toString() {
        return carName + " : " + MOVE_SYMBOL.repeat(distance);
    }
}
