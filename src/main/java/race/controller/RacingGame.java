package race.controller;

import java.util.List;
import race.domian.Cars;
import race.strategy.RandomMoveStrategy;
import race.ui.InputView;
import race.ui.ResultView;

public class RacingGame {

    public void play(RandomMoveStrategy moveStrategy) {
        ResultView.getFirstQuestion();
        List<String> namesOfCar = InputView.getCarName();

        ResultView.getSecondQuestion();
        int playCount = InputView.getPlayCount();

        ResultView.getNewLine();
        ResultView.getResultSentence();

        Cars cars = new Cars(namesOfCar);

        for (int i = 0; i < playCount; i++) {
            cars.move(moveStrategy);
            ResultView.getResult(cars.getNames(), cars.getPosition());
            ResultView.getNewLine();
        }
        ResultView.getWinner(cars.findWinners());
    }
}