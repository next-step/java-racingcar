package racing;

import racing.view.InputView;

public class RacingGameRunner {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.printQuestionCar();
        int carCount = inputView.requireInputInteger();
        inputView.printQuestionTime();
        int timeCount = inputView.requireInputInteger();
        RacingGame racingGame = new RacingGame(carCount, timeCount);
        racingGame.startRacing();
    }
}
