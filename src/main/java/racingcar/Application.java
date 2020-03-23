package racingcar;

import racingcar.policy.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int count = inputView.view(InputView.INPUT_CAR_COUNT_MESSAGE);
        int time = inputView.view(InputView.INPUT_TIME_MESSAGE);

        RacingGame racingGame = new RacingGame(time, count, new RandomMovingPolicy());

        outputView.print(OutputView.GAME_RESULT_MESSAGE);
        while (!racingGame.isGameOver()) {
            racingGame.play();
            outputView.view(racingGame.getCars());
        }
    }
}
