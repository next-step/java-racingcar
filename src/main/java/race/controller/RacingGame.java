package race.controller;

import race.domian.Cars;
import race.strategy.RandomMoveStrategy;
import race.ui.InputView;
import race.ui.ResultView;

public class RacingGame {

    public void play(RandomMoveStrategy moveStrategy) {
        ResultView.getFirstQuestion();
        int carCount = InputView.getCarCount();

        ResultView.getSecondQuestion();
        int playCount = InputView.getPlayCount();

        ResultView.getNewLine();
        ResultView.getResultSentence();

        Cars cars = new Cars(carCount);

        for (int i = 0; i < playCount; i++) {
            cars.move(moveStrategy);
            ResultView.getPosition(cars.getPosition());
            ResultView.getNewLine();
        }
    }
}
