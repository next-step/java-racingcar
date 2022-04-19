package racingcar.racing;

import racingcar.play.ZeroToNineRandomPolicy;
import racingcar.racing.dto.RacingGameParam;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class App {
    public static void main(String[] args) {

        RacingGameParam racingGameParam = InputView.enterParam();

        RacingGame racingGame = new RacingGame(new ZeroToNineRandomPolicy());

        racingGame.startRacingGame(racingGameParam.getCarNumber(), racingGameParam.getTryNumber());

        for(int i = 0 ; i < racingGameParam.getTryNumber(); i++) {
            ResultView.show(racingGame.getResult(i));
        }

    }

}
