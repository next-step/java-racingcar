package racingcar.v1;

import racingcar.v1.domain.RacingGame;
import racingcar.v1.domain.policy.ZeroToNineRandomPolicy;
import racingcar.v1.dto.RacingGameParam;
import racingcar.v1.view.InputView;
import racingcar.v1.view.ResultView;
import racingcar.v2.domain.car.Position;

public class App {
    public static void main(String[] args) {

        Position position = new Position(-1);

        RacingGameParam racingGameParam = InputView.enterParam();

        RacingGame racingGame = new RacingGame(new ZeroToNineRandomPolicy());



        racingGame.playGame(racingGameParam);

        for(int i = 0 ; i < racingGameParam.getTryNumber(); i++) {
            ResultView.show(racingGame.getRacingRecords(i), i == 0);
        }

        ResultView.printWinners(racingGame.getWinners(racingGameParam.getTryNumber()));

    }

}
