package service;

import racingcar.Cars;
import racingcar.RaceCondition;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Cars> raceResult = new ArrayList<>();
    private final RaceCondition raceCondition = new RaceCondition();

    public List<Cars> start(String carsName, int tryCount) {
        Cars cars = Cars.builder()
                .carsName(carsName)
                .raceCondition(raceCondition)
                .build();

        if (!cars.checkSize()) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 경주 할 수 있습니다.");
        }

        for (int count = 0; count < tryCount; count++) {
            cars.addMove();
            raceResult.add(new Cars(cars.getCopyCarList(), raceCondition));
        }

        return raceResult;
    }

}
