package step5.dto;

import step5.domain.GameRound;

public class RacingGameConditionDTO {
    private final String carNames;
    private final GameRound gameRound;


    private RacingGameConditionDTO(String carNames, int tryCount) {
        this.carNames = carNames;
        gameRound = GameRound.of(tryCount);
    }

    public static RacingGameConditionDTO of(String carNames, int tryCount) {
        return new RacingGameConditionDTO(carNames, tryCount);
    }

    public String getCarNames() {
        return carNames;
    }

    public GameRound getGameRound() {
        return gameRound;
    }
}
