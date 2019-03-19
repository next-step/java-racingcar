package racingcar.domain;

import racingcar.util.RandomUtils;
import racingcar.view.GameResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(String names) {
        this.cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public GameResult play(int time) {
        GameResult result = new GameResult();

        for (int i = 0; i < time; i++) {
            this.cars = move(cars);
            result.addRound(new Round(this.cars));
        }

        return result;
    }

    private List<Car> move(List<Car> cars) {
        return cars.stream()
                .map(it -> it.move(RandomUtils.getRandomNumber(10)))
                .collect(Collectors.toList());
    }

    public int getNumberOfCars() {
        return cars.size();
    }
}