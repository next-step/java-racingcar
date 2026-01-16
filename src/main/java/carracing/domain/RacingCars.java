package carracing.domain;

import carracing.util.RandomUtil;

import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        validate(racingCars);
        this.racingCars = racingCars;
    }

    public void moveAll(NumberGenerator generator) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(generator.generate());
        }
    }

    private void validate(List<RacingCar> racingCars) {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 합니다.");
        }
    }
}
