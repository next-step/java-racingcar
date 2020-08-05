package step3;

import step3.domain.Car;
import step3.domain.RacingCar;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Map;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carNumber = InputView.setRacingCarNumber(scanner);
        int gameCount = InputView.setMotorRacingCount(scanner);

        Map<Integer, Car> carInfoMap = RacingCar.preparedCar(carNumber);

        ResultView.gameResult();
        ResultView.carRace(carInfoMap, carNumber, gameCount);

    }
}
