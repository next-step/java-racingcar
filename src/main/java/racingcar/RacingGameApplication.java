package racingcar;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        RacingGame racingGame = inputView.input();
        resultView.result(racingGame);
    }
}
