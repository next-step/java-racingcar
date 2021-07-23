package racingGame;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int repeatCount = InputView.inputRepeatCount();

        Game game = new Game(carCount, repeatCount);

        ResultView.printGameStart();
        for (int i = 0; i < repeatCount; i++) {
            List<Integer> list = RandomNumber.makeRandomNumber(carCount);
            game.runOnce(list);
            ResultView.printResult(game.getCarsStatus());
        }
    }
}
