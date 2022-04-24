package racingcar.racing;

import racingcar.racing.policy.ZeroToNineRandomPolicy;
import racingcar.racing.dto.RacingGameParam;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class App {
    public static void main(String[] args) {

        RacingGameParam racingGameParam = InputView.enterParam();

        RacingGame racingGame = new RacingGame(new ZeroToNineRandomPolicy());

        racingGame.playGame(racingGameParam);

        for(int i = 0 ; i < racingGameParam.getTryNumber(); i++) {
            ResultView.show(racingGame.getRacingRecords(i), i == 0);
        }

        ResultView.printWinners(racingGame.getWinners(racingGameParam.getTryNumber()));

    }

}
