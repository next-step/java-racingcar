package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingController {
    public static void race(String carNames, int numberOfRaces) {
        Racing racing = new Racing(carNames);

        final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        IntStream.range(0, numberOfRaces).forEach(i -> {
            List<Car> resultCars = racing.race(randomNumberGenerator);
            ResultView.printMovementOneRace(resultCars);
        });

        ResultView.printRacingWinner(racing.getWinnerCars());
    }
}
