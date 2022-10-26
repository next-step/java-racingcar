package race.controller;

import java.util.List;
import race.domian.Car;
import race.domian.Cars;
import race.strategy.RandomMoveStrategy;
import race.ui.InputView;
import race.ui.ResultView;

public class RacingGame {

    public static final String BAR = "-";

    public void play(RandomMoveStrategy randomMoveStrategy) {
        ResultView.getFirstQuestion();
        int carCount = InputView.getCarCount();

        ResultView.getSecondQuestion();
        int playCount = InputView.getPlayCount();

        ResultView.getNewLine();
        ResultView.getResultSentence();

        List<Car> cars = Cars.from(carCount);

        while (playCount > 0) {
            for (int i = 0; i < carCount; i++) {
                cars.get(i).move(randomMoveStrategy);
                System.out.println(BAR.repeat(cars.get(i).getPosition()));
            }
            ResultView.getNewLine();
            --playCount;
        }
    }
}
