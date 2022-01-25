package racingcar;


import java.util.List;
import racingcar.racing.GameLauncher;
import racingcar.ui.RacingCarInput;

public class Application {

    public static void main(String[] args) {
        GameLauncher gameLauncher = new GameLauncher();
        gameLauncher.start();
    }
}
