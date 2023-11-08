package step3;

import step3.domain.Car;
import step3.domain.Racing;
import step3.helper.CarFactory;
import step3.view.InputView;

import java.util.List;

public class RacingApp {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.inputNumberOfCars();
        int round = inputView.inputRound();

        List<Car> cars = CarFactory.createCars(numberOfCars);

        Racing racing = new Racing(cars, round);
        racing.start();
    }

}
