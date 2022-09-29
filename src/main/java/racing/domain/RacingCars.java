package racing.domain;

import racing.domain.strategy.MovingStrategy;
import racing.domain.strategy.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {

        validate(racingCars);
        this.racingCars = racingCars;
    }

    public static RacingCars from(final CarNames carNames) {

        final List<RacingCar> racingCarList = convert(carNames.list());
        return new RacingCars(racingCarList);
    }

    private void validate(final List<RacingCar> racingCars) {

        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException("참가하는 자동차는 1대 이상이어야 합니다.");
        }
    }

    private static List<RacingCar> convert(final List<CarName> carNames) {

        List<RacingCar> racingCars = new ArrayList<>();
        for (CarName carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    public void play(final RacingAttempt racingAttempt, final RacingScore racingScore) {

        while (racingAttempt.canAttempt()) {
            racingAttempt.remain();
            enter(new RandomMovingStrategy());
            racingScore.save(this);
        }
    }

    public void enter(final MovingStrategy movingStrategy) {

        for (RacingCar racingCar : racingCars) {
            playRacingCar(racingCar, movingStrategy);
        }
    }

    private void playRacingCar(final RacingCar racingCar, final MovingStrategy movingStrategy) {

        if (movingStrategy.isMovable()) {
            racingCar.move();
        }
    }

    public List<RacingCar> score() {

        return Collections.unmodifiableList(this.racingCars);
    }
}
