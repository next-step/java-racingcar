package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private static final String INPUT_COUNT_ERROR_MESSAGE = "0 이상의 수를 입력해주세요.";

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getValue() {
        return Collections.unmodifiableList(racingCars);
    }

    public static RacingCars create(int count) {
        validate(count);
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            racingCars.add(new RacingCar());
        }

        return new RacingCars(racingCars);
    }

    public void move(MovableStrategy movableStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(movableStrategy);
        }
    }

    private static int validate(int value) {
        if (value <= 0) {
            throw new IllegalStateException(INPUT_COUNT_ERROR_MESSAGE);
        }
        return value;
    }
}
