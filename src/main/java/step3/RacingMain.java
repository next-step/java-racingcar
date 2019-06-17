package step3;

import java.util.List;

public class RacingMain {

    public static void main(String[] arg) {
        RacingGame racingGame = new RacingGame();

        String[] userInput = InputView.inputMessage();
        racingGame.carPositionsInit(userInput[0]);

        int gameNumber = stringToInteger(userInput[1]);
        while (gameNumber > 0) {
            List<CarDto> carPositions = racingGame.move();
            OutputView.racingResult(carPositions);
            gameNumber--;
        }
    }

    private static int stringToInteger(String convertStr){
        return Integer.parseInt(convertStr);
    }

}
