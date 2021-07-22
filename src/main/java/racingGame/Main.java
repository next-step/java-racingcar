package racingGame;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int carSize = InputView.inputCarSize();
        int repeatCount = InputView.inputRepeatCount();

        Game game = new Game(carSize, repeatCount);

        ResultView.printGameStart();
        for (int i = 0; i < repeatCount; i++) {
            List<Integer> list = RandomNumber.makeRandomNumber(carSize);
            game.runOnce(list);
            ResultView.printResult(game.getCarsStatus());
        }
    }
}
