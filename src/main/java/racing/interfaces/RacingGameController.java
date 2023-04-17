package racing.interfaces;

import racing.domain.Car;
import racing.domain.Garage;
import racing.domain.Racing;

import java.util.List;

public class RacingGameController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCarInput = inputView.setNumberOfCarInput();
        int numberOfMatchInput = inputView.setNumberOfMatchInput();

        Garage garage = new Garage();
        List<Car> cars = garage.createCars(numberOfCarInput);

        Racing racing = new Racing(numberOfMatchInput, cars);

        ResultView resultView = new ResultView();

        while (racing.getLeftMatchCounts() > 0) {
            resultView.printResult(racing.race());
        }

    }
}
