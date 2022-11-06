package race.controller;

import race.domian.Cars;
import race.strategy.RandomMoveStrategy;
import race.ui.InputView;
import race.ui.ResultView;

public class RacingGame {

    public void play(RandomMoveStrategy moveStrategy) {
        ResultView.getFirstQuestion();
        String[] carName = InputView.getCarName();
        int carCount = carName.length;

        ResultView.getSecondQuestion();
        int playCount = InputView.getPlayCount();

        ResultView.getNewLine();
        ResultView.getResultSentence();

        Cars cars = new Cars(carName, carCount);

        for (int i = 0; i < playCount; i++) {
            cars.move(moveStrategy);
            ResultView.getResult(cars.getNames(), cars.getPosition());
            ResultView.getNewLine();
        }
    }
}