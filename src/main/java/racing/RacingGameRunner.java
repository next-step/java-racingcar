package racing;

import racing.common.Question;
import racing.view.InputView;

public class RacingGameRunner {
    public static void main(String[] args) {
        InputView.printQuestion(Question.CAR_COUNT.getQuestion());
        String carName = InputView.getStringAnswer();
        InputView.printQuestion(Question.TIME_COUNT.getQuestion());
        int time = InputView.getIntAnswer();
        RacingGame racingGame = new RacingGame(carName, time);
        racingGame.startRacing();
    }
}
