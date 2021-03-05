package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        RacingInput userInput = inputView.getUserInput();

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < userInput.getCarSize(); i++) {
            cars.add(new RandomlyMovingCar());
        }

        for (int i = 0; i < userInput.getMoves(); i++) {
            cars.forEach(Car::move);
            resultView.printCar(cars);
        }
    }

}
