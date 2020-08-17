package racingcar;

import racingcar.domain.RacingCars;
import racingcar.view.InputChannel;
import racingcar.view.InputView;
import racingcar.view.OutputChannel;
import racingcar.view.ResultView;


public class RacingCarMain {
    public static void main(String[] args) {

        InputView inputView = new InputView(InputChannel.createSystemIn(), OutputChannel.createSystemOut());
        RacingCars racingCars = new RacingCars(inputView.getCarCounts(),inputView.getRacingCounts());
        ResultView resultView = new ResultView(OutputChannel.createSystemOut());
        resultView.printStartResult();
        while (racingCars.yesRacingCond()) {
            racingCars.yesRacingCars();
            resultView.printCars(racingCars.getCars());
            resultView.printLine();
        }
    }

}
