package step3;

import java.util.List;

public class RacingMain {

    public static void main(String[] arg) {
        String[] userInput = InputView.inputMessage();
        RacingGame racingGame = new RacingGame();
        racingGame.carPositionsInit(userInput[0]);

        List<CarDto> carPositions = null;
        int gameNumber = stringToInteger(userInput[1]);
        while (gameNumber > 0) {
            carPositions = racingGame.move();
            OutputView.racingResult(carPositions);
            gameNumber--;
        }
        OutputView.racingWinnerResult(carPositions);
    }

    private static int stringToInteger(String convertStr){
        return Integer.parseInt(convertStr);
    }

}
