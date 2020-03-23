package racing;

public class RacingGameMain {
    public RacingGameMain() {
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingVO racingVO = inputView.inputValue();
        RacingGame racingGame = new RacingGame(racingVO);
        ResultView resultView = new ResultView(racingVO, racingGame);
        resultView.view();
    }
}