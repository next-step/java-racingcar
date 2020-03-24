package racingcar;

import racingcar.model.RacingGame;
import racingcar.model.RacingGameSetting;
import racingcar.policy.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carNames = inputView.inputCarNames();
        int time = inputView.inputCarCount();

        RacingGameSetting setting = new RacingGameSetting(new RandomMovingPolicy(), carNames, time);
        RacingGame racingGame = new RacingGame(setting);

        outputView.print(OutputView.GAME_RESULT_MESSAGE);
        while (!racingGame.isGameOver()) {
            racingGame.play();
            outputView.view(racingGame.getCars().toList());
        }
    }
}
