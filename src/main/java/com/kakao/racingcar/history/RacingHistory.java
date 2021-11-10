package com.kakao.racingcar.history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingHistory {
    private final List<RoundHistory> roundHistories = new ArrayList<>();

    public void logging(RoundHistory roundHistory) {
        roundHistories.add(roundHistory);
    }

    public Map<Integer, List<CarHistory>> getResult() {
        return roundHistories.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(RoundHistory::getRound, RoundHistory::getCarHistories),
                        Collections::unmodifiableMap));
    }

    public List<String> getWinner() {
        RoundHistory lastRound = roundHistories.get(roundHistories.size() - 1);

        return lastRound.roundWinner().stream()
                .map(CarHistory::getUserName)
                .collect(Collectors.toList());
    }
}
