package racingcar;

import java.util.List;

public class RacingCarRunner {
    public static void main(String[] args) {
        List<String> carNames = Input.readCarNames();
        int tryCount = Input.readTryCount();
        GameBoard gameBoard = new GameBoard(carNames, tryCount);

        for (int i = 0; i <= tryCount; i++) {
            gameBoard.run(i);
        }
        gameBoard.getWinnerNames();
    }
}
