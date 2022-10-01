package racinggame;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();
        RacingGame game = new RacingGame(new RandomNumberGenerator());
        RacingGameResult result = game.run(carNames.size(), tryCount);
        OutputView.printResult(result);
    }

}
