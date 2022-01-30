package racingcar;


import racingcar.controller.GameLauncher;
import racingcar.util.RandomUtil;

public class Application {

    public static void main(String[] args) {
        GameLauncher gameLauncher = new GameLauncher();
        gameLauncher.start();
    }
}
