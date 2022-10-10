package racingcar.race;

import racingcar.view.ResultView;

public class Result {
    private ResultView resultView;
    public Result(ResultView resultView) {
        this.resultView = resultView;
    }

    public void racingStartAndPrint(RacingModel racingModel, RacingCars cars) {
        System.out.println("실행 결과");
        for (int trys = 0; trys < racingModel.getTryCount(); trys++) {
            racingModel.racingStart(cars);
            resultView.printEachRacingStep();
        }
    }
}
