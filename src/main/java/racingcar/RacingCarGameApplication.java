package racingcar;

import racingcar.io.IOManager;

import java.util.List;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        IOManager ioManager = applicationContext.getIOManager();
        List<String> carNames = ioManager.getCarNames();
        int rounds = ioManager.getRounds();
        RacingGame game = new RacingGame(carNames, rounds);
        game.play();
    }
}
