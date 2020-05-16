package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RacingGame {

    private static final int BOUND = 10;
    private static final int FORWARD_POSSIBLE_NUMBER = 4;
    private static final Random GENERATOR = new Random();

    private int time;
    private List<RacingCar> racingCars;
    private int[] carPositions;

    private RacingGame(int countOfCar, int time, List<RacingCar> racingCars) {
        this.time = time;
        this.racingCars = racingCars;
        this.carPositions = new int[countOfCar];
    }

    public static RacingGame of(int countOfCar, int time) {
        return new RacingGame(countOfCar, time, readyRacingCars(countOfCar));
    }

    private static List<RacingCar> readyRacingCars(int racingCarCount) {
        return new ArrayList<RacingCar>(){{
            IntStream.range(0, racingCarCount).forEach(v -> add(RacingCar.ready()));
        }};
    }

    public int[] move() {
        for(int i = 0; i < racingCars.size(); i++) {
            if (isMoveForward()) {
                carPositions[i] = racingCars.get(i).forward();
                continue;
            }

            carPositions[i] = racingCars.get(i).stop();
        }

        return carPositions;
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