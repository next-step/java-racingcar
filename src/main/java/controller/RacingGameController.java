package controller;

import domain.MovingStrategy;
import domain.Racing;
import view.InputView;
import view.ResultView;

public class RacingGameController {

    private final InputView inputView;
    private final ResultView resultView;
    private static final MovingStrategy movingStrategy = new MovingStrategy();
    public RacingGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        int carCount = inputView.getCarCount();
        int playCount = inputView.getPlayCount();

        play(new Racing(carCount), playCount);
    }

    private void play(Racing racing, int playCount) {
        resultView.printResult();

        for (int i = 0; i < playCount; i++) {
            racing.race(movingStrategy);
            resultView.printPlayResult(racing.getCars());
        }
    }
}
