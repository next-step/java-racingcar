package step3;

import step3.domain.Car;
import step3.domain.RacingCar;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String racingCarName = InputView.setRacingCarNumber(scanner);
        Map<String, Car> carInfoMap = RacingCar.preparationForGame(racingCarName);

        int motorRacingCount = InputView.setMotorRacingCount(scanner);

        ResultView.gameResult();
        ResultView.carRace(carInfoMap, motorRacingCount);

        int maxPosition = RacingCar.findMaxPosition(carInfoMap);
        List<String> winners = RacingCar.racingCarWinner(carInfoMap, maxPosition);
        String winnerMmeber = ResultView.printWinner(winners);
        System.out.println(winnerMmeber);
    }
}
