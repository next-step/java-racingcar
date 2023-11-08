package step3.model;

import java.util.Random;

public class Round {


    private final RacingCars racingCars;

    public Round(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void race() {
        for (Car car : racingCars.getRacingCars()) {
            car.move(getRandomNumber());
        }
    }

    private Integer getRandomNumber() {
        return new Random().nextInt(10);
    }
}
