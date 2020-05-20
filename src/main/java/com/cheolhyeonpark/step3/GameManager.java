package com.cheolhyeonpark.step3;

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
    }
}
