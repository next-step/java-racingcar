package domain;

import domain.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {

    private List<RacingCar> racingCars;

    private RacingCars(final String participant) {

        this.racingCars = participate(convert(participant));
    }

    private RacingCars(final RacingCar racingCar) {

        this.racingCars = List.of(racingCar);
    }

    public static RacingCars from(final String participant) {

        return new RacingCars(participant);
    }

    public static RacingCars from(final RacingCar racingCar) {

        return new RacingCars(racingCar);
    }

    private int convert(final String attempt) {

        try {
            int number = Integer.parseInt(attempt);
            validateZero(number);
            return number;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    private void validateZero(final int attempt) {

        if (attempt == 0) {
            throw new IllegalArgumentException("입력값은 1 이상이어야 합니다.");
        }
    }

    private List<RacingCar> participate(final int participant) {

        List<RacingCar> racingCars = new ArrayList<>();
        for(int i = 0; i < participant; i++) {
            racingCars.add(RacingCar.init());
        }
        return racingCars;
    }

    public int count() {

        return this.racingCars.size();
    }

    public void roundPlay(final MovingStrategy movingStrategy) {

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
