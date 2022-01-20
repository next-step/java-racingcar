package racingcar;


import java.util.List;
import racingcar.service.GameLauncher;
import racingcar.ui.RacingCarInput;

public class Application {

    public static void main(String[] args) {
        RacingCarInput racingCarInput = new RacingCarInput();
        List<String> carNameList = racingCarInput.getCarName();
        int raceCount = racingCarInput.getRaceCount();
        GameLauncher gameLauncher = new GameLauncher(carNameList);
        while (0 < raceCount) {
            gameLauncher.moveForwardAll();
            gameLauncher.printRacing();
            raceCount--;
            System.out.println("------------------------------");
        }
        gameLauncher.printWinner();
    }
}
