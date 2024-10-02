package racingGame;

import java.util.List;
import java.util.Map;

public class RacingGameController {
    private final RacingCarInputView inputView;
    private final RacingCarOutputView outputView;

    public RacingGameController() {
        this.inputView = new RacingCarInputView();
        this.outputView = new RacingCarOutputView();
    }

    public void run() {
        String[] carNames = inputView.getCarNames();
        int attempts = inputView.getAttempts();

        RacingGame racingGame = new RacingGame(carNames, attempts, new RandomMovementCondition());
        List<Map<String, Integer>> allStates = racingGame.run();

        outputView.printGame(allStates, racingGame.getWinners());
    }
}