package com.kakao.racingcar.domain;

import com.kakao.racingcar.history.RacingHistory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.kakao.racingcar.domain.CarConfig.BEGIN_INDEX;

public class CarCollection {
    private final List<Car> cars;
    private final RacingHistory racingHistory;

    public CarCollection(int totalCars) {
        this.cars = IntStream.range(BEGIN_INDEX, totalCars)
                .boxed()
                .map(Car::new)
                .collect(Collectors.toList());
        this.racingHistory = new RacingHistory();
    }

    public void tryMoveCars(int round, List<Integer> conditionNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).tryMove(conditionNumbers.get(i));
        }
        racingHistory.logging(round, cars);
    }

    public int size() {
        return cars.size();
    }

    public RacingHistory getRacingHistory() {
        return racingHistory;
    }

}
