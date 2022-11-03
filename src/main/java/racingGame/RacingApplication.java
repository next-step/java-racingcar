package racingGame;

import racingGame.domain.Number;
import racingGame.strategy.RandomNumberGenerate;

import java.util.Arrays;
import java.util.List;

import static racingGame.view.InputView.carNames;
import static racingGame.view.InputView.tryCount;

public class RacingApplication {

    public static void main(String[] args) {
        List<String> carNames = Arrays.asList(carNames().split(","));
        int tryCount = new Number(tryCount()).getValue();

        RacingGame racingGame = new RacingGame(
                new RandomNumberGenerate(),carNames,tryCount);

        racingGame.race();
    }

}