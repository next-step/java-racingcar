package racingcar.domain;

import racingcar.view.OutputView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {

    public RacingCars play(RacingCars racingCars, int numberOfTimes) {
        IntStream.range(0, numberOfTimes).forEach(a -> {
            racingCars.race();
            OutputView.printRacing(racingCars.showCars());
        });
        return racingCars;
    }

    public Winners pickWinners(RacingCars racingCars) {
        List<Car> racingResult = racingCars.showCars();
        racingResult.sort(Comparator.comparing(Car::showDistance, Comparator.reverseOrder()));

        Car firstWinner = racingResult.get(0);

        List<Car> collect = racingResult.stream()
                .filter(car -> car.showDistance() == firstWinner.showDistance())
                .collect(Collectors.toList());

        return new Winners(collect);
    }
}
