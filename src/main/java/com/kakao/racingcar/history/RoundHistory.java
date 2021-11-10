package com.kakao.racingcar.history;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoundHistory {

    private final int round;
    private final List<CarHistory> carHistories;

    private static final Integer OUT_OF_INDEX = -1;

    public RoundHistory(int round, List<CarHistory> carHistories) {
        this.round = round;
        this.carHistories = carHistories;
    }

    public int getRound() {
        return round;
    }

    public List<CarHistory> getCarHistories() {
        return Collections.unmodifiableList(carHistories);
    }

    public List<CarHistory> roundWinner() {
        int maxPosition = carHistories.stream()
                .map(CarHistory::getPosition)
                .max(Integer::compareTo)
                .orElse(OUT_OF_INDEX);

        return carHistories.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

}
