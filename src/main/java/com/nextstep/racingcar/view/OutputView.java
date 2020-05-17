package com.nextstep.racingcar.view;

import com.nextstep.racingcar.application.RacingGameResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private RacingGameResult racingGameResult;

    public OutputView(RacingGameResult racingGameResult) {
        this.racingGameResult = racingGameResult;
    }

    public String toStringResult() {
        return racingGameResult.getRoundResults().stream()
                .map(roundResult -> roundResult.toStringResult() + "\n")
                .collect(Collectors.joining());
    }

    public String toStringWinner() {
        List<String> winners = this.racingGameResult.getWinners();
        String winnerString = winners.stream().map(name -> name + ", ").collect(Collectors.joining());

        return winnerString.substring(0, winnerString.length() - 2) + "가 최종 우승했습니다.";
    }
}
