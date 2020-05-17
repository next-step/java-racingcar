package race;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private static final int BOUND = 10;
    private static final int FORWARD_POSSIBLE_NUMBER = 4;
    private static final Random GENERATOR = new Random();

    private int time;
    private List<RacingCar> racingCars;
    private int[] carPositions;

    private RacingGame(int countOfCar, int time) {
        this.time = time;
        this.carPositions = new int[countOfCar];
    }

    public static RacingGame of(int countOfCar, int time) {
        return new RacingGame(countOfCar, time);
    }

    public void readyRacingCars(int countOfCar) {
        initRacingCars(countOfCar);
    }

    private void initRacingCars(int racingCarCount) {
        this.racingCars = Stream.generate(RacingCar::ready).limit(racingCarCount).collect(Collectors.toList());
    }

    public List<RacingCar> start() {
        for(RacingCar racingCar : racingCars) {
            if (isMoveForward()) {
                racingCar.forward();
                continue;
            }

            racingCar.stop();
        }

        return racingCars;
    }

    private boolean isMoveForward() {
        return GENERATOR.nextInt(BOUND) >= FORWARD_POSSIBLE_NUMBER;
    }

    public int getTime() {
        return time;
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}