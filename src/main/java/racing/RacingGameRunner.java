package racing;

import racing.common.Question;
import racing.view.InputView;

public class RacingGameRunner {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(
          InputView.printQuestionAndgetAnswer(Question.CAR_COUNT.getQuestion()), 
          InputView.printQuestionAndgetAnswer(Question.TIME_COUNT.getQuestion())
        );
        racingGame.startRacing();
    }
}
