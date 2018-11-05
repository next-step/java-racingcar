package racingGame;

import racingGame.view.InputView;
import racingGame.view.QuestionType;

public class RacingGrameRunner {

    public static void main(String args[]) {
        RacingGameLogger logger = new RacingGameLogger();
        RacingGame racingGame = new RacingGame();
        racingGame.setLogger(logger);

        int cars = InputView.inputInteger(QuestionType.CARS.getQuestion());
        int times = InputView.inputInteger(QuestionType.TIMES.getQuestion());

        System.out.println("\n실행 결과");
        racingGame.move(cars, times);
    }
}
