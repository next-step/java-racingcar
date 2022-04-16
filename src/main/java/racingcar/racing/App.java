package racingcar.racing;

import racingcar.generator.NumberGenerator;
import racingcar.play.ZeroToNineRandomPolicy;
import racingcar.racing.dto.RacingGameParam;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class App {
    public static void main(String[] args) {

        RacingGameParam racingGameParam = InputView.enterParam();

        RacingGame racingGame = new RacingGame(new ZeroToNineRandomPolicy(new NumberGenerator()));

        racingGame.startRacingGame(racingGameParam);

        ResultView.show(racingGameParam.getTryNumber(), racingGame);
    }

}
