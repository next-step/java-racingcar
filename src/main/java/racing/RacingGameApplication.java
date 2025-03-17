package racing;

import racing.entity.RacingGame;
import racing.message.GameMessage;
import racing.rule.MoveRule;
import racing.rule.RacingGameMoveRule;
import racing.view.RacingGameInputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        int carCount = RacingGameInputView.getIntegerInput(GameMessage.CAR_COUNT_MESSAGE);
        int roundCount = RacingGameInputView.getIntegerInput(GameMessage.ATTEMPT_COUNT_MESSAGE);
        MoveRule moveRule = new RacingGameMoveRule();

        RacingGame racingGame = new RacingGame(carCount, roundCount, moveRule);
        racingGame.playRacingGame();
    }
}
