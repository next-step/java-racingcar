package com.kakao.racingcar.history;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoundHistory {

    private final int round;
    private final List<CarHistory> carHistories;

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
        return carHistories.stream()
                .filter(car -> car.isEqualPosition(getMaxPosition()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    private CarHistory getMaxPosition(){
        return carHistories.stream()
                .max(CarHistory::compareTo)
                .orElse(CarHistory.createNonMoveHistory());
    }

}
