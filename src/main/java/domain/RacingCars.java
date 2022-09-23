package domain;

import domain.strategy.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {

    private Number count;
    private List<RacingCar> racingCars;

    private RacingCars(final String cars) {

        this.count = Number.from(cars);
        this.racingCars = participate(count.getNumber());
    }

    private RacingCars(final RacingCar racingCar) {

        this.racingCars = List.of(racingCar);
    }

    public static RacingCars from(final String cars) {

        return new RacingCars(cars);
    }

    public static RacingCars from(final RacingCar racingCar) {

        return new RacingCars(racingCar);
    }

    private List<RacingCar> participate(final int count) {

        List<RacingCar> racingCars = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            racingCars.add(RacingCar.init());
        }
        return racingCars;
    }

    public int count() {

        return this.racingCars.size();
    }

    public void play() {

        for (RacingCar racingCar : racingCars) {
            racingCar.move(new RandomMovingStrategy());
        }
    }

    public List<RacingCar> score() {

        return Collections.unmodifiableList(this.racingCars);
    }
}
