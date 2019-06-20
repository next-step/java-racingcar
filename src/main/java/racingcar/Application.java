package racingcar;

import racingcar.model.GameRequest;
import racingcar.controller.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.start();
        try {
            // 레이싱 게임을 위한 입력 값
            String inputOfCarNames = InputView.askCarNames();
            int inputOfRound = InputView.askRound();
            GameRequest gameRequest = GameRequest.valueOf(inputOfRound, inputOfCarNames);
            // 게임 시작
            run(gameRequest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        OutputView.end();
    }

    private static void run(GameRequest gameRequest) {
        // 준비
        RacingGame racingGame = RacingGame.generate(gameRequest);
        // 경기 시작
        racingGame.start();
        OutputView.ready(racingGame.start());
        while (!racingGame.isGameOver()) {
            OutputView.getCurrentGameResult(racingGame.playOfOneRound());
        }
        // 경기 종료: 최종 우승
        OutputView.winningResult(racingGame.getWinningResult());
    }
}
