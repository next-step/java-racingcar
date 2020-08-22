package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputChannel;
import racingcar.view.InputView;
import racingcar.view.OutputChannel;
import racingcar.view.ResultView;


public class RacingCarMain {
    public static void main(String[] args) {

        InputView inputView = new InputView(InputChannel.createSystemIn( ), OutputChannel.createSystemOut( ));
        RacingGame racingGame = new RacingGame(inputView.getCarCounts( ), inputView.getRacingCounts( ));
        ResultView resultView = new ResultView(OutputChannel.createSystemOut( ));
        resultView.printStartResult( );
        while (racingGame.yesRacingCond( )) {
            racingGame.yesRacingCars( );
            resultView.printCars(racingGame.getCars( ));
            resultView.printLine( );
        }

    }

}
