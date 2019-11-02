package racing;

import racing.RacingGame;
import racing.RacingInputView;
import racing.RacingResultView;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingInputView racingInputView = new RacingInputView();
        RacingResultView racingResultView = new RacingResultView(racingInputView.carCount);
        RacingGame racingGame = new RacingGame(racingInputView);
        racingResultView.print(racingGame.start());
    }

}
