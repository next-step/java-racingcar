package RcingCarV2;

import RcingCarV2.model.StageResult;
import RcingCarV2.view.InputView;
import RcingCarV2.view.ResultView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingGame racingCar = new RacingGame();
        List<StageResult> stageResults = racingCar.start(inputView.getNames(), inputView.getStage());

        ResultView resultView = new ResultView();
        resultView.print(stageResults);
    }
}
