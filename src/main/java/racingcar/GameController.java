package racingcar;

import java.util.List;

public class GameController {

    private static final ConsoleInput INPUT = new ConsoleInput();
    private static final ConsoleOutput OUTPUT = new ConsoleOutput();

    public static void main(String[] args) {
        int carQuantity = INPUT.getCarQuantity();
        int movementCount = INPUT.getMovementCount();

        RacingGame racingGame = new RacingGame(carQuantity);

        OUTPUT.resultMessage();
        for (int i = 0; i < movementCount; i++) {
            List<Integer> resultPosition = racingGame.play();
            resultPosition.forEach(OUTPUT::position);
            OUTPUT.newLine();
        }
    }
}
