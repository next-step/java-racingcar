package study.step3;

import study.step3.util.NumberGenerator;
import study.step3.view.ResultView;

import java.util.List;

public class RacingGame {
    private static final int MAX_VALUE = 10;
    private GameConfig gameConfig;

    public RacingGame(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void play() {
        ResultView.printStart();
        for (int i = 0; i < gameConfig.getGameCount(); i++) {
            carMove();
        }
    }

    private void carMove() {
        for (Car car : gameConfig.getCars()) {
            car.move(NumberGenerator.randomVal(MAX_VALUE));
        }
        ResultView.show(gameConfig.getCars());
        ResultView.printEnd();
    }
}
