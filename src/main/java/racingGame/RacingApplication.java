package racingGame;

import racingGame.domain.Cars;
import racingGame.domain.Number;
import racingGame.strategy.RandomNumberGenerate;

import java.util.Arrays;
import java.util.List;

import static racingGame.view.InputView.carNames;
import static racingGame.view.InputView.tryCount;
import static racingGame.view.ResultView.racingWinner;

public class RacingApplication {

    public static void main(String[] args) {
        Cars cars = Cars.makeCars(Arrays.asList(carNames().split(",")));
        int tryCount = new Number(tryCount()).getValue();

        RacingGame racingGame = new RacingGame(
                new RandomNumberGenerate(),cars,tryCount);

        racingWinner(racingGame.race());
    }
}