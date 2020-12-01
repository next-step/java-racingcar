package com.nextstep.racingcar.view;

import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.round.CarRoundResult;
import com.nextstep.racingcar.domain.round.RoundResult;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private List<RoundResult> racingGameResult;

    public OutputView(List<RoundResult> racingGameResult) {
        this.racingGameResult = racingGameResult;
    }

    public String toStringResult() {
        return this.racingGameResult.stream()
                .map(roundResult -> roundResult.toStringResult() + "\n")
                .collect(Collectors.joining());
    }

    public String toStringWinner() {
        List<String> winners = this.getWinners();
        String winnerString = winners.stream().map(name -> name + ", ").collect(Collectors.joining());

        return winnerString.substring(0, winnerString.length() - 2) + "가 최종 우승했습니다.";
    }

    private List<String> getWinners() {
        RoundResult lastRound = this.racingGameResult.get(this.racingGameResult.size() - 1);
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
