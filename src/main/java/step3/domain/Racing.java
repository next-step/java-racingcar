package step3.domain;

import java.util.stream.IntStream;

public class Racing {

    private Cars cars;
    private int attemptNumber;
    private final RacingRule racingRule;

    public Racing(int carNumber, int attemptNumber) {
        this.racingRule = new RacingRule();
        this.cars = new Cars(carNumber);
        this.attemptNumber = attemptNumber;


    }

    public Cars getCars() {
        return cars;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void racingRule() {

        cars.getCars().forEach(car->{
            car.moveCar(racingRule.moveRule());
        });

        System.out.println(" ");
    }
}
