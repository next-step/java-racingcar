package step3;

import step3.domain.Car;
import step3.domain.CarOperator;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;

public class RacingController {

    public static void startGame() {
        int numberOfCars = InputView.putNumOfCars();
        int numberOfAttempts = InputView.putNumOfAttempts();
        List<Car> carList = Car.factory(numberOfCars);
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            List<Car> racingList = CarOperator.drive(carList);
            OutputView.eachRacingResult(racingList);
        }
    }
}
