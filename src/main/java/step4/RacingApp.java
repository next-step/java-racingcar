package step4;

import step4.domain.Racing;
import step4.helper.CarFactory;
import step4.domain.Car;
import step4.view.InputView;

import java.util.List;

public class RacingApp {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.inputNumberOfCars();
        int round = inputView.inputRound();

        List<Car> cars = CarFactory.createCars("");

        Racing racing = new Racing(cars, round);
        racing.start();
    }

}
