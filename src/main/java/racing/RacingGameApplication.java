package racing;

import racing.entity.RacingGame;
import racing.message.GameMessage;
import racing.rule.RandomMoveRule;
import racing.view.RacingGameInputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        int carCount = RacingGameInputView.getIntegerInput(GameMessage.CAR_COUNT_MESSAGE);
        int roundCount = RacingGameInputView.getIntegerInput(GameMessage.ATTEMPT_COUNT_MESSAGE);
        RandomMoveRule randomMoveRule = new RandomMoveRule();

        RacingGame racingGame = new RacingGame(carCount, roundCount, randomMoveRule);
        racingGame.playRacingGame();
    }
}