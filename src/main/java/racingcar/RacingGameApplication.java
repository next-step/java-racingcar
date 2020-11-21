package racingcar;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.input();
        RacingGame racingGame = RacingGame.newRacingGame(inputView.getCarNames(), inputView.getRounds());
        racingGame.play();
        resultView.print(racingGame);
    }
}
