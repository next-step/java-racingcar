package racingcar;

import java.util.List;


public class RacingCarRunner {
    public static void main(String[] args) {
        List<String> carNames = Input.processCarNames();
        int tryCount = Input.processTryCount();
        Game game = new Game(carNames);

        Output.printInitialStatus(game.getCars());
        for (int i = 0; i < tryCount; i++) {
            game.run();
            Output.printCarStatus(game.getCars());
        }
        Output.printWinners(game.getWinnerNames());
    }
}
