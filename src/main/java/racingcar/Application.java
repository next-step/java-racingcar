package racingcar;


import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.service.GameLauncher;
import racingcar.view.RacingCarInput;

public class Application {

    public static void main(String[] args) {
        RacingCarInput racingCarInput = new RacingCarInput();
        List<String> carNameList = racingCarInput.getCarName();
        final int endRaceCount = racingCarInput.getRaceCount();

        GameLauncher gameLauncher = new GameLauncher(carNameList, endRaceCount);

        StringBuilder gameLog = new StringBuilder();
        while (gameLauncher.isEnd()) {
            gameLauncher.moveForwardAll();
            List<Car> carList = gameLauncher.getRacingCarList();

            for(Car car : carList){
                gameLog.append(car);
                gameLog.append("\n");
            }
            gameLog.append("------------------------------\n");
        }

        List<String> winnerList = gameLauncher.getWinner().stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        gameLog.append(String.join(",",winnerList));

        System.out.println(gameLog);
    }
}
