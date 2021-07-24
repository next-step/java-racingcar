package racingGame;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> names = InputView.inputCarNames();
        int repeatCount = InputView.inputRepeatCount();

        Game game = new Game(names, repeatCount);

        ResultView.printGameStart();
        for (int i = 0; i < repeatCount; i++) {
            List<Integer> list = RandomNumber.makeRandomNumber(names.size());
            game.runOnce(list);
            ResultView.printResult(game.getCars());
        }
    }
}
