package race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private int time;
    private List<RacingCar> racingCars;
    private int[] carPositions;
    private final MovingStrategy movingStrategy;

    private RacingGame(int countOfCar, int time, MovingStrategy movingStrategy) {
        this.time = time;
        this.carPositions = new int[countOfCar];
        this.movingStrategy = movingStrategy;
    }

    public static RacingGame of(int countOfCar, int time, MovingStrategy movingStrategy) {
        return new RacingGame(countOfCar, time, movingStrategy);
    }

    public void readyRacingCars(int countOfCar) {
        initRacingCars(countOfCar);
    }

    private void initRacingCars(int racingCarCount) {
        this.racingCars = Stream.generate(RacingCar::ready).limit(racingCarCount).collect(Collectors.toList());
    }

    public List<RacingCar> start() {
        for(RacingCar racingCar : racingCars) {
            if (movingStrategy.isMovable()) {
                racingCar.forward();
                continue;
            }

            racingCar.stop();
        }

        return racingCars;
    }

    public int getTime() {
        return time;
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}