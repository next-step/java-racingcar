package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.RacingGameSetting;
import racingcar.domain.Winner;
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

        outputView.nextLine();
        outputView.print(OutputView.GAME_RESULT_MESSAGE);
        while (!racingGame.isGameOver()) {
            racingGame.play();
            outputView.view(racingGame.getCars().toList());
        }

        Winner winners = new Winner(racingGame.getCars());
        outputView.print(winners.getWinner());
    }
}
