package racingcar;


import java.util.List;
import racingcar.service.GameLauncher;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarLog;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = RacingCarInput.getCarName();
        int endRaceCount = RacingCarInput.getRaceCount();

        GameLauncher gameLauncher = new GameLauncher(carNames, endRaceCount, new RandomMoveStrategy());

        StringBuilder gameLog = new StringBuilder();
        while (gameLauncher.isOngoing()) {
            gameLauncher.race();
            gameLog.append(gameLauncher.getCars());
        }

        RacingCarLog.printWinner(gameLog, gameLauncher.getCars());

        System.out.println(gameLog);
    }
}
