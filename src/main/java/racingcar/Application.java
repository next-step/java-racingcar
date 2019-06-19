package racingcar;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.start();
        try {
            run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        OutputView.end();
    }

    private static void run() {
        // 준비
        String inputOfCarNames = InputView.askCarNames();
        int inputOfRound = InputView.askRound();
        RacingGame racingGame = RacingGame.generate(inputOfCarNames);

        // 경기 시작
        OutputView.ready(racingGame.start());
        for (int i = 0; i < inputOfRound; i++) {
            OutputView.getCurrentGameResult(racingGame.playOfOneRound());
        }
        // 경기 종료: 최종 우승
        OutputView.winningResult(racingGame.winningResult());
    }
}
