package domain;

import domain.strategy.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {

    private Number participant;
    private List<RacingCar> racingCars;

    private RacingCars(final String participant) {

        this.participant = Number.from(participant);
        this.racingCars = participate(this.participant.getNumber());
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

    public void roundPlay() {

        for (RacingCar racingCar : racingCars) {
            racingCar.move(new RandomMovingStrategy());
        }
    }

    public List<RacingCar> score() {

        return Collections.unmodifiableList(this.racingCars);
    }
}
