package step3.model;

import java.util.Random;

public class Round {
    private static final String ROUND_END = "";

    private final RacingCars racingCars;

    public Round(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void race() {
        for (Car car : racingCars.getRacingCars()) {
            car.move(getRandomNumber());
            System.out.println(car.getMovingDistance());
        }
        System.out.println(ROUND_END);
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }
}
