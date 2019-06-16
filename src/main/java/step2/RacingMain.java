package step2;

import java.util.List;

public class RacingMain {

    public static void main(String[] arg) {
        InputView inputView = new InputView();
        Integer[] userInput = inputView.inputMessage();
        outputView outputView = new outputView();
        RacingGame racingGame = new RacingGame();
        racingGame.carPositionsInit(userInput[0]);
        while (userInput[1] > 0) {
            List<Integer> carPositions = racingGame.move();
            outputView.racingResult(carPositions);
            userInput[1]--;
        }
    }

}
