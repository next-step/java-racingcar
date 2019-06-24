package step2;

public class RacingGameApplication {

    private InputView input;

    public RacingGameApplication() {
        this.input = new InputView();
    }

    public static void main(String[] args) {

        RacingGameApplication app = new RacingGameApplication();
        int carNumber = app.input.inputCarNumber();
        int tryCount = app.input.inputTryCount();

        RacingGame racingGame = new RacingGame();
        racingGame.setInitPosition(carNumber);

        System.out.println("실행결과");

        while (tryCount-- > 0) {
            racingGame.startRacing(carNumber);
            racingGame.resultView();
        }
    }
}
