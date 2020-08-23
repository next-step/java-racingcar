package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCounts;
import racingcar.domain.RacingGame;
import racingcar.view.InputChannel;
import racingcar.view.InputView;
import racingcar.view.OutputChannel;
import racingcar.view.ResultView;

import java.util.List;

import static racingcar.view.ResultView.printCars;
import static racingcar.view.ResultView.printEmptyLine;

public class RacingCarMain {
    public static void main(String[] args) {

        InputView inputView = new InputView(InputChannel.createSystemIn(), OutputChannel.createSystemOut());
        RacingGame racingGame = new RacingGame(inputView.getCarCounts(), new RacingCounts(inputView.getRacingCounts()));
        ResultView resultView = new ResultView(OutputChannel.createSystemOut());
        resultView.printStartResult();
        printRacingGameResult(racingGame);
    }

    private static void printRacingGameResult(RacingGame racingGame) {
        for (int i = 0; i < racingGame.getRacingCounts(); i++) {
            printCars(getRaceResults(racingGame));
            printEmptyLine();
        }
    }

    private static List<Car> getRaceResults(RacingGame racingGame) {
        return racingGame.startRacing().getRaceResults();
    }

}
