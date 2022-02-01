package racingcar;


import java.util.List;
import racingcar.service.GameLauncher;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarLog;

public class Application {

    public static void main(String[] args) {
        RacingCarInput racingCarInput = new RacingCarInput();
        List<String> carNameList = racingCarInput.getCarName();
        int endRaceCount = racingCarInput.getRaceCount();

        GameLauncher gameLauncher = new GameLauncher(carNameList, endRaceCount);

        StringBuilder gameLog = new StringBuilder();
        while (gameLauncher.isOngoing()) {
            gameLauncher.race(new RandomMoveStrategy());
            gameLog.append(gameLauncher.getCars());
        }

        RacingCarLog.printWinner(gameLog, gameLauncher.getCars());

        System.out.println(gameLog);
    }
}
