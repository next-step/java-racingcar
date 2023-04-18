package racing.interfaces;

import racing.domain.*;

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
        RacingCars racingCars = new RacingCars();

        while (racing.getLeftMatchCounts() > 0) {
            racingCars = racing.race();
            resultView.printMatchResult(racingCars);
        }

        resultView.printWinnerResult(Winner.award(racingCars));

    }
}
