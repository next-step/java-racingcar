package step4;

import step4.domain.Car;
import step4.domain.Racing;
import step4.helper.CarFactory;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class RacingApp {

    public static void main(String[] args) throws IllegalAccessException {
        String carNameStr = InputView.inputNumberOfCars();
        int round = InputView.inputRound();

        List<Car> cars = CarFactory.createCars(carNameStr);

        Racing racing = new Racing(cars, round);
        List<Car> winners = racing.start();
        ResultView.printWinners(winners);
    }

}
