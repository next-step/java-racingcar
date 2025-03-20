package racingcar;

public class RacingCar implements Comparable<RacingCar> {

    private static final String MOVE_SYMBOL = "-";
    private int distance;
    private final RacingCarName carName;
    private final RacingCarMoveStrategy racingCarMoveStrategy;

    public RacingCar(RacingCarName carName, RacingCarMoveStrategy racingCarMoveStrategy) {
        this.carName = carName;
        this.racingCarMoveStrategy = racingCarMoveStrategy;
    }

    public void moveIfMovable() {
        if (isMovable()) {
            move();
        }
    }

    private void move() {
        this.distance++;
    }

    private boolean isMovable() {
        return racingCarMoveStrategy.isMovable();
    }

    public RacingCarName getCarName() {
        return carName;
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
