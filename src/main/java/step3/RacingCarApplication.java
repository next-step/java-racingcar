package step3;

import step3.model.Car;
import step3.service.RacingService;
import step3.ui.InputView;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTry = inputView.getNumberOfTry();

        RacingService racingService = new RacingService();
        List<Car> cars = racingService.makeCars(numberOfCars);
    }
}
