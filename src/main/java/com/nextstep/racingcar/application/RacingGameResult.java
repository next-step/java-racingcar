package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.round.CarRoundResult;
import com.nextstep.racingcar.domain.round.RoundResult;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<RoundResult> roundResultList;

    private RacingGameResult(List<RoundResult> roundResultList) {
        this.roundResultList = roundResultList;
    }

    public static RacingGameResult create(List<RoundResult> roundResultList) {
        List<RoundResult> unmodifiableList = Collections.unmodifiableList(new ArrayList<>(roundResultList));
        return new RacingGameResult(unmodifiableList);
    }

    public int size() {
        return this.roundResultList.size();
    }

    public List<RoundResult> getRoundResults() {
        return new ArrayList<>(this.roundResultList);
    }

    public List<String> getWinners() {
        RoundResult lastRound = this.roundResultList.get(this.roundResultList.size() - 1);
        MoveLength longestMoveLength = getLongestMoveLength(lastRound);
        return lastRound.getValues().stream()
                .filter(carRoundResult -> carRoundResult.getMoveLength().equals(longestMoveLength))
                .map(CarRoundResult::getDriverName)
                .collect(Collectors.toList());
    }

    private MoveLength getLongestMoveLength(RoundResult lastRound) {
        CarRoundResult maxCarRoundResult = lastRound.getValues().stream()
                .max(Comparator.comparing((CarRoundResult carRoundResult) -> carRoundResult.getMoveLength().toInt()))
                .get();

        return MoveLength.createByValue(maxCarRoundResult.getMoveLength().toInt());
    }
}
