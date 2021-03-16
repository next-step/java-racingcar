package racing;

import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RaceGameMain {

    public static void main(String[] args){
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView.getCarNames(), inputView.getTryCount());
        racingGame.start();

        new ResultView(racingGame.resultDto());
    }
}
