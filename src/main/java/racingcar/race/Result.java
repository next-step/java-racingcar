package racingcar.race;

import racingcar.view.ResultView;

import java.util.List;

public class Result {
    private ResultView resultView;
    public Result(ResultView resultView) {
        this.resultView = resultView;
    }

    public void racingStartAndPrint(RacingModel racingModel, List<Car> cars) {
        System.out.println("실행 결과");
        for (int trys = 0; trys < racingModel.getTryCount(); trys++) {
            racingModel.racingStart(cars);
            resultView.printEachRacingStep();
        }
    }
}
