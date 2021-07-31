package racing.model;

import java.util.*;

import static java.util.Collections.max;
import static java.util.stream.Collectors.toList;

public class RacingCars {
    private static final int MIN_RACING_CAR_COUNT = 1;

    private List<RacingCar> racingCars;

    public RacingCars(String[] racingCarNames) {
        validateMinCount(racingCarNames.length);
        prepare(racingCarNames);
    }

    private void validateMinCount(int racingCarCount) {
        if (racingCarCount < MIN_RACING_CAR_COUNT) {
            throw new IllegalArgumentException(String.format("자동차는 %d대 이상이어야 합니다.", MIN_RACING_CAR_COUNT));
        }
    }

    private void prepare(String[] racingCarNames) {
        racingCars = Arrays.stream(racingCarNames)
                .map(RacingCar::new)
                .collect(toList());
    }

    public void moveForwardOneStepOrStop(MovingCondition movingCondition) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveForwardOneStepOrStop(movingCondition);
        }
    }

    String[] getNames() {
        return racingCars.stream()
                .map(RacingCar::getName)
                .toArray(String[]::new);
    }

    int[] getPositions() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .toArray();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> findWinners() {
        RacingCar fastestRacingCar = max(racingCars);
        return racingCars.stream()
                .filter(racingCar -> racingCar.isEqualPosition(fastestRacingCar))
                .collect(toList());
    }
}
