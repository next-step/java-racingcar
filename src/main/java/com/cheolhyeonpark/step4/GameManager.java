package com.cheolhyeonpark.step4;

import com.cheolhyeonpark.step4.domain.RacingGame;
import com.cheolhyeonpark.step4.view.InputView;
import com.cheolhyeonpark.step4.view.ResultView;

public class GameManager {

    private final ResultView resultView = new ResultView();
    private final InputView inputView = new InputView();

    public void run() {

        RacingGame racingGame =
                new RacingGame(inputView.inputNumberOfCars(), inputView.inputNumberOfStages());

        resultView.printResultTitle();
        while (racingGame.hasNextStage()) {
            racingGame.playStage();
            resultView.printStageResult(racingGame.getResultOfStage());
        }
        resultView.printWinners(racingGame.getWinners());
    }
}
