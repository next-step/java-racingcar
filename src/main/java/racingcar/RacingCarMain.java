package racingcar.domain;

import racingcar.view.InputChannel;
import racingcar.view.InputView;
import racingcar.view.OutputChannel;
import racingcar.view.ResultView;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView(InputChannel.createSystemIn( ), OutputChannel.createSystemOut( ));
        RacingGame racingGame = new RacingGame(InputView.getCarNames(), InputView.getRacingCounts());
        ResultView resultView = new ResultView(OutputChannel.createSystemOut( ));
        resultView.printStartResult();
        for (int i = 0 ; i < racingGame.getRacingCounts(); i++) {
            resultView.printCars(racingGame.startRacing());
            resultView.printEmptyLine();
        }
    }
}
