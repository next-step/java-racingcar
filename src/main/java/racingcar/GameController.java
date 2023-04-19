package racingcar;

import java.util.List;

public class GameController {
    private InputView inputView;
    private ResultView resultView;

    public GameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        List<String> carNames = inputView.readCarNames();
        int trialNumber = inputView.readTrialNumber();

        GameService gameService = new GameService(carNames, trialNumber);
        this.resultView.printResult(gameService.play());
    }
}
