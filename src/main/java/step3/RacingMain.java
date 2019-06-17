package step3;

import java.util.List;

public class RacingMain {

    public static void main(String[] arg) {
        RacingGame racingGame = new RacingGame();

        Integer[] userInput = InputView.inputMessage();
        racingGame.carPositionsInit(userInput[0]);
        while (userInput[1] > 0) {
            List<CarDto> carPositions = racingGame.move();
            OutputView.racingResult(carPositions);
            userInput[1]--;
        }
    }

}
