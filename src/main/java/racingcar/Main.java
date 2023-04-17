package racingcar;

import static racingcar.InputView.askCar;
import static racingcar.InputView.askRound;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(askCar(), askRound(), new RandomNumberGenerator());
        GameResult gameResult = game.play();
        Billboard.printGameResult(gameResult);
    }
}
