package racingcar;


import java.util.List;
import racingcar.service.GameLauncher;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarLog;

public class Application {

    public static void main(String[] args) {
        RacingCarInput racingCarInput = new RacingCarInput();
        List<String> carNameList = racingCarInput.getCarName();
        int endRaceCount = racingCarInput.getRaceCount();

        GameLauncher gameLauncher = new GameLauncher(carNameList, endRaceCount);

        StringBuilder gameLog = new StringBuilder();
        while (!gameLauncher.isEnd()) {
            gameLauncher.moveForwardAll();
            RacingCarLog.printCars(gameLog, gameLauncher.getRacingCarList());
        }

        RacingCarLog.printWinner(gameLog, gameLauncher.getWinner());

        System.out.println(gameLog);
    }
}
