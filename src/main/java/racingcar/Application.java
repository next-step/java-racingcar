package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.RacingGame;

public class Application {

    private static RacingGame racingGame;

    public static void main(String[] args) {
        OutputView.start();
        try {
            run();
        } catch (Exception e) {
            OutputView.println(e.getMessage());
        }
        OutputView.end();
    }

    private static void run() {
        // 준비
        String askCarNames = InputView.askCarNames();
        int time = InputView.askRound();
        racingGame = RacingGame.generate(time, askCarNames);

        // 시작
        OutputView.ready(racingGame.getResult());
        while (!racingGame.isGameOver()) {
            OutputView.playResult(racingGame.racing());
        }
        // 결과 출력
        OutputView.winningResult(racingGame.getFinalResult());
    }
}
