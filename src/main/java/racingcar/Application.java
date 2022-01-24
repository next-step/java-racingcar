package racingcar;


import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.service.GameLauncher;
import racingcar.ui.RacingCarInput;

public class Application {

    public static void main(String[] args) {
        RacingCarInput racingCarInput = new RacingCarInput();
        List<String> carNameList = racingCarInput.getCarName();

        int raceCount = racingCarInput.getRaceCount();

        StringBuilder gameLog = new StringBuilder();
        GameLauncher gameLauncher = new GameLauncher(carNameList);
        while (0 < raceCount) {
            gameLauncher.moveForwardAll();
            List<Car> carList = gameLauncher.getRacingCarList();

            for(Car car : carList){
                gameLog.append(car);
                gameLog.append("\n");
            }
            gameLog.append("------------------------------\n");

            raceCount--;
        }

        List<String> winnerList = gameLauncher.getWinner().stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        gameLog.append(String.join(",",winnerList));

        System.out.println(gameLog);
    }
}
