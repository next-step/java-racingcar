package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public String display() {
        return carName + " : " + MOVE_SYMBOL.repeat(distance);
    }

    public RacingCarName getCarName() {
        return carName;
    }

    public static List<RacingCar> createRacingCars(String[] carNames, RacingCarMoveStrategy moveStrategy) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(new RacingCar(new RacingCarName(carName), moveStrategy));
        }

        return racingCars;
    }

    public static List<RacingCar> toSortedRacingCars(List<RacingCar> racingCars) {
        racingCars = new ArrayList<>(racingCars);
        Collections.sort(racingCars);
        return racingCars;
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(o.distance, distance);
    }
}
