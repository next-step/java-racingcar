package carracing;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        List<String> carNames = inputView.inputCars();
        int tryCount = inputView.intTryCount();

        OutputView outputView = new OutputView();
        RacingGame racingGame = new RacingGame(carNames);
        for (int i = 0; i < tryCount; i++) {
            outputView.printRacingResult(racingGame.doRacing(new RandomMovingStrategy()));
        }
        outputView.printWinner(racingGame.findWinner());
    }
}
