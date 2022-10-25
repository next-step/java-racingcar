package racingcar;

import racingcar.race.RacingCars;
import racingcar.race.RacingModel;
import racingcar.race.Result;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class App {
    public static void main(String[] args) {
        InputView.printStartScreen();

        String names[] = InputView.receiveNames();

        InputView.printInputUsername();

        int tryCount = InputView.receiveTryCount();

        RacingCars cars = RacingCars.of(names);
        RacingModel racingModel = new RacingModel(tryCount);

        Result result = new Result();
        result.racingStartAndPrint(racingModel, cars);

        ResultView.printWinner(new RacingCars(Result.judgeWinner(cars)));

        InputView.close();
    }

}
