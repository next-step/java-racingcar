package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();

        int count = inputView.getCount();
        int number = inputView.getNumber();

        RacingGame game = new RacingGame(count, number);
        while(game.isNotEnd()) {
            Result result = game.move();
            ResultView.print(result);
        }
    }
}
