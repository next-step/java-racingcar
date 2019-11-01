package com.seok.racing.domain;

public class GameResult {

    private final Winners winners;
    private final RacingResult racingResult;

    public GameResult(Winners winners, RacingResult racingResult) {
        this.winners = winners;
        this.racingResult = racingResult;
    }

    public Winners getWinners() {
        return winners;
    }

    public RacingResult getRacingResult() {
        return racingResult;
    }
}
