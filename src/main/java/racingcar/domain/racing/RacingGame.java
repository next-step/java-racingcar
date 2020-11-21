package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.dto.input.RacingCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public List<Cars> startRacingGame(Cars cars, RacingCount racingCount) {
        List<Cars> records = new ArrayList<>();

        for (int i = 0; i < racingCount.getValue(); i++) {
            Cars postRaceCars = race(cars, new RandomMovingStrategy());
            records.add(postRaceCars);
            cars = postRaceCars;
        }
        return records;
    }

    private Cars race(Cars cars, MovingStrategy movableGenerator) {

        List<Car> racingResult = cars.getValue().stream()
                .map(car -> car.move(movableGenerator))
                .collect(Collectors.toList());

        return new Cars(racingResult);
    }

}
