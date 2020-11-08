package racingcar;

import racingcar.utils.RandomNumberGenerator;

public class RacingSimulator {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void race(Car[] cars) {
        for (Car car : cars) {
            Integer randomNumber = randomNumberGenerator.generatorNumber(10);
            car.move(randomNumber);
        }
    }
}
