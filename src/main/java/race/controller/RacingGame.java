package race.controller;

import java.util.List;
import race.domian.Cars;
import race.strategy.RandomMoveStrategy;
import race.view.Input;
import race.view.Result;

public class RacingGame {

    public void play(RandomMoveStrategy moveStrategy) {
        Result.getFirstQuestion();
        List<String> namesOfCar = Input.getCarName();

        Result.getSecondQuestion();
        int playCount = Input.getPlayCount();

        Result.getNewLine();
        Result.getResultSentence();

        Cars cars = new Cars(namesOfCar);

        for (int i = 0; i < playCount; i++) {
            cars.move(moveStrategy);
            Result.getResult(cars.getNames(), cars.getPosition());
            Result.getNewLine();
        }
        Result.getWinner(cars.findWinners());
    }
}