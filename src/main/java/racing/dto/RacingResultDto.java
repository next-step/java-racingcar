package racing.dto;

import racing.domain.RacingGame;

import java.util.List;

public class RacingResultDto {
    private RacingGame racingGame;

    public RacingResultDto(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public List<Integer> calculateRacingResult() {
        return racingGame.calculateRacingScore();
    }
}
