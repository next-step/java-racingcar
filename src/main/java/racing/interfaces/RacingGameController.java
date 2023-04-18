package racing.interfaces;

import racing.domain.Car;
import racing.domain.Garage;
import racing.domain.Racing;

import java.util.List;

public class RacingGameController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String nameOfCarInput = inputView.setNameOfCarInput();
        int numberOfMatchInput = inputView.setNumberOfMatchInput();

        Garage garage = new Garage();
        List<Car> cars = garage.createCars(nameOfCarInput);

        Racing racing = new Racing(numberOfMatchInput, cars);

        ResultView resultView = new ResultView();

        while (racing.getLeftMatchCounts() > 0) {
            resultView.printResult(racing.race());
        }

    }
}
