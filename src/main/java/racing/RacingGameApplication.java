package racing;

import racing.domain.RacingGameInfo;
import racing.view.InputView;
import racing.view.ResultView;


public class RacingGameApplication {
    public static void main(String[] args) {
        RacingGameInfo rgInfo = new InputView().setInfo();
        RacingGame racingGame = new RacingGame(rgInfo);

        ResultView.init();
        racingGame.tryEvent();
    }
}
