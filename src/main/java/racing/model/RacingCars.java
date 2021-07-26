package racing.model;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RacingCars {
    private static final int MIN_RACING_CAR_COUNT = 1;

    private List<RacingCar> racingCars;

    public RacingCars(int racingCarCount) {
        validateMinCount(racingCarCount);
        prepare(racingCarCount);
    }

    private void validateMinCount(int racingCarCount) {
        if (racingCarCount < MIN_RACING_CAR_COUNT) {
            throw new IllegalArgumentException(String.format("자동차는 %d대 이상이어야 합니다.", MIN_RACING_CAR_COUNT));
        }
    }

    private void prepare(int racingCarCount) {
        racingCars = Stream.generate(RacingCar::new)
                .limit(racingCarCount)
                .collect(toList());
    }

    public int getSize() {
        return racingCars.size();
    }

    public void moveOrStop() {
        for (RacingCar racingCar : racingCars) {
            Number number = NumberGenerator.getNewRandomNumber();
            racingCar.moveOrStop(number);
        }
    }

    public int[] getRacingCarPositions() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .toArray();
    }
}
