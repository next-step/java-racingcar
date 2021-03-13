package racingcar.module;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private RacingRound racingRound;

    public RacingRound startGame(Cars cars, int tryNum) {
        racingRound = new RacingRound();
        for (int num = 0; num < tryNum; num++) {
            cars.playCarGame();
            List<Car> copyCars = cars.getCars().stream()
                    .map(Car::clone).collect(Collectors.toList());

            racingRound.insertResult(copyCars, num);

        }

        return racingRound;
    }

}
