package step2;

import java.util.List;

public class RacingMain {

    public static void main(String[] arg) {
        Integer[] userInput = InputView.inputMessage();
        RacingGame racingGame = new RacingGame(userInput[0]);
        while (userInput[1] > 0) {
            List<Car> carPositions = racingGame.move();
            OutputView.racingResult(carPositions);
            userInput[1]--;
        }
    }

}
