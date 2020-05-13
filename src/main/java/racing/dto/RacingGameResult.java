package racing.dto;

import racing.domain.RacingGame;

import java.util.List;

public class RacingGameResult {
    private List<Integer> racingResult;

    public RacingGameResult(RacingGame racingGame) {
        this.racingResult = racingGame.calculateRacingScore();
    }

    public List<Integer> getRacingResult() {
        return this.racingResult;
    }
}
