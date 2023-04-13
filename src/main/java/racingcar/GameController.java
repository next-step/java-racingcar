package racingcar;

public class GameController {
    private InputView inputView;
    private ResultView resultView;

    public GameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        int carNumber = inputView.readCarNumber();
        int trialNumber = inputView.readTrialNumber();

        GameService gameService = new GameService(carNumber, trialNumber);
        gameService.play();
    }
}
