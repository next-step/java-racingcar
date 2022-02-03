package racingcar;


import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarLog;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = RacingCarInput.getCarName();
        int endRaceCount = RacingCarInput.getRaceCount();

        RacingGame racingGame = new RacingGame(carNames, endRaceCount, new RandomMoveStrategy());

        StringBuilder gameLog = new StringBuilder();
        while (racingGame.isOngoing()) {
            racingGame.race();
            gameLog.append(racingGame.getCars());
        }

        RacingCarLog.printWinner(gameLog, racingGame.getCars());

        System.out.println(gameLog);
    }
}
