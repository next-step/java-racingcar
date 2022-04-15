package study.step3;

import study.step3.view.InputView;
import study.step3.view.ResultView;

public class Application {
    public static void main(String[] args) {
        //레이싱 게임을 위한 세팅
        GameConfig gameConfig = new GameConfig(InputView.gameCount(), InputView.carCount());
        RacingGame racingGame = new RacingGame(gameConfig);

        //레이싱 게임
        racingGame.play();

    }
}
