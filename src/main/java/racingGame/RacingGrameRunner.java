package racingGame;

import racingGame.view.InputView;
import racingGame.view.QuestionType;

public class RacingGrameRunner {

    public static void main(String args[]) {
        RacingGame racingGame = new RacingGame();

        int cars = InputView.inputInteger(QuestionType.CARS.getQuestion());
        int times = InputView.inputInteger(QuestionType.TIMES.getQuestion());

        racingGame.move(cars, times);
    }
}
