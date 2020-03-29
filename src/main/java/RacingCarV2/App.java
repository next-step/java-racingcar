package RacingCarV2;

import RacingCarV2.model.StageResult;
import RacingCarV2.view.InputView;
import RacingCarV2.view.ResultView;

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
