package step3;

import step3.car.RacingGame;
import step3.generator.GenerateNumberStrategy;
import step3.generator.RandomNumberGenerator;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();

        RacingGame racingGame = RacingGame.of(inputView.getMoveCount(), inputView.getNumberOfCars());
        GenerateNumberStrategy numberGenerator = new RandomNumberGenerator();
        List<int[]> result = racingGame.start(numberGenerator);

        ResultView resultView = new ResultView();
        resultView.print(result);
    }
}
