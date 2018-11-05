package racingGame;

import racingGame.view.InputView;
import racingGame.view.QuestionType;
import racingGame.view.ResultView;

public class RacingGameRunner {

    public static void main(String args[]) {
        int cars = InputView.inputInteger(QuestionType.CARS.getQuestion());
        int times = InputView.inputInteger(QuestionType.TIMES.getQuestion());

        RacingGame racingGame = new RacingGame(cars, times);

        System.out.println("\n실행 결과");
        while (racingGame.hasRemainTime()) {
            racingGame.move();
            ResultView.log(racingGame.getCarPositions());
        }
    }
}
