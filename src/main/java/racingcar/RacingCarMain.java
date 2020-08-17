package racingcar;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputChannel;
import racingcar.view.ResultView;


public class RacingCarMain {
    public static void main(String[] args) {

        int carCounts = InputView.getCarCounts();
        int racingCounts = InputView.getRacingCounts();

        RacingCars racingCars = new RacingCars(carCounts, racingCounts);
        ResultView resultView = new ResultView(OutputChannel.createSystemOut());
        resultView.printStartResult();
        while (racingCars.yesRacingCond( )) {
            racingCars.yesRacingCars( );
        resultView.printCars(racingCars.getCars());
        resultView.printLine();
        }
    }

}
