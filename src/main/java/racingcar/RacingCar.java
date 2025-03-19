package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private static final String MOVE_SYMBOL = "-";
    private int distance;
    private final RacingCarMoveStrategy racingCarMoveStrategy;

    public RacingCar() {
        this(new RandomRacingCarMoveStrategy());
    }

    // visible for testing
    RacingCar(RacingCarMoveStrategy racingCarMoveStrategy) {
        this.racingCarMoveStrategy = racingCarMoveStrategy;
    }

    public void moveIfMovable() {
        if (racingCarMoveStrategy.isMovable()) {
            move();
        }
    }

    private void move() {
        this.distance++;
    }

    private boolean isMovable() {
        return racingCarMoveStrategy.isMovable();
    }

    public String display() {
        return MOVE_SYMBOL.repeat(distance);
    }

    public static List<RacingCar> createRacingCars(int carCount) {
        if (carCount < 1) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
        }

        List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }

        return racingCars;
    }

}
