package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.car.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoundHistory {

    private final int round;
    private final List<CarHistory> carHistories;

    private RoundHistory(int round, List<CarHistory> carHistories) {
        this.round = round;
        this.carHistories = carHistories;
    }

    public static RoundHistory of(int round, List<Car> cars) {
        List<CarHistory> carHistories = cars.stream()
                .map(CarHistory::of)
                .collect(Collectors.toList());
        return new RoundHistory(round, carHistories);
    }

    public int getRound() {
        return round;
    }

    public List<CarHistory> getCarHistories() {
        return Collections.unmodifiableList(carHistories);
    }

}
