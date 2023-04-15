package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;

public class RacingController {
    public static void race(int numberOfCars, int numberOfRaces) {
        Racing racing = new Racing(numberOfCars, numberOfRaces);
        final NumberGenerator numberGenerator = new RandomNumberGenerator();

        racing.excute(numberGenerator);
    }
}
