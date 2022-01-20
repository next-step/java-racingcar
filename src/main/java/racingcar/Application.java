package racingcar;


import java.util.List;
import racingcar.service.GameLauncher;
import racingcar.ui.RacingCarInput;

public class Application {

    public static void main(String[] args) {
        List<String> carNameList = RacingCarInput.getCarName();
        int raceCount = RacingCarInput.getRaceCount();
        GameLauncher gameLauncher = new GameLauncher(carNameList);
        while (0 < raceCount) {
            gameLauncher.moveForwardAll();
            gameLauncher.printRacing();
            raceCount--;
        }
        gameLauncher.printWinner();
    }
}
