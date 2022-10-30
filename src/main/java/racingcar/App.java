package racingcar;

import racingcar.race.RacingCars;
import racingcar.race.RacingModel;
import racingcar.race.Result;
import racingcar.race.TryCount;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class App {
    public static void main(String[] args) {

        String names[] = InputView.receiveNames();

        InputView.printInputUsername();

        int tryCount = new TryCount(InputView.receiveTryCount()).getTryCount();

        RacingModel racingModel  = new RacingModel(names, tryCount);

        Result result = new Result();
        result.racingStartAndPrint(racingModel, racingModel.getCars());

        ResultView.printWinner(new RacingCars(result.judgeWinner(racingModel.getCars())));

        InputView.close();
    }

}
