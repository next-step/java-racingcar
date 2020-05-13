package step3;

public class RacingGameMain {

    public void racingGameMain() {
        InputView inputView = new InputView();
        inputView.inputCarCount();
        inputView.inputTime();

        RacingGame racingGame = new RacingGame(inputView.getTime(), inputView.getCarCount());

    }
}
