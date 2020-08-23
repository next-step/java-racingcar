package racingcar;

import racingcar.domain.Car_old;
import racingcar.domain.RacingCounts;
import racingcar.domain.RacingGame_old;
import racingcar.view.InputChannel;
import racingcar.view.InputView;
import racingcar.view.OutputChannel;
import racingcar.view.ResultView;

import java.util.List;

import static racingcar.view.ResultView.printCars;
import static racingcar.view.ResultView.printEmptyLine;

public class RacingCarMain_old {
    public static void main(String[] args) {

        InputView inputView = new InputView(InputChannel.createSystemIn(), OutputChannel.createSystemOut());
        RacingGame_old racingGameOld = new RacingGame_old(inputView.getCarCounts(), new RacingCounts(inputView.getRacingCounts()));
        ResultView resultView = new ResultView(OutputChannel.createSystemOut());
        resultView.printStartResult();
        printRacingGameResult(racingGameOld);
    }

    private static void printRacingGameResult(RacingGame_old racingGameOld) {
        for (int i = 0; i < racingGameOld.getRacingCounts(); i++) {
            printCars(getRaceResults(racingGameOld));
            printEmptyLine();
        }
    }

    private static List<Car_old> getRaceResults(RacingGame_old racingGameOld) {
        return racingGameOld.startRacing().getRaceResults();
    }

}
