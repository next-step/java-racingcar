package racinggame;

import com.google.common.base.Preconditions;

public class RacingGameParameters {
    public static final int MIN_GAME_ROUND = 1;
    public static final int MIN_CAR_AMOUNT = 1;
    private final int gameRound;
    private final int carQuantity;
    private int currentRound = 0;

    public RacingGameParameters(int gameRound, int carQuantity) {
        Preconditions.checkArgument(gameRound >= MIN_GAME_ROUND, "게임 라운드는 " + MIN_GAME_ROUND + " 이상이어야 합니다.");
        Preconditions.checkArgument(carQuantity >= MIN_CAR_AMOUNT, "차량 수는" + MIN_CAR_AMOUNT + "이상이어야 합니다.");
        this.gameRound = gameRound;
        this.carQuantity = carQuantity;
    }

    public int getCarQuantity() {
        return carQuantity;
    }

    public int getGameRound() {
        return gameRound;
    }

    public void increaseCurrentRound() {
        Preconditions.checkState(!this.isFinished(), "게임이 이미 끝났습니다.");
        currentRound += 1;
    }

    public boolean isFinished() {
        return currentRound >= gameRound;
    }
}

