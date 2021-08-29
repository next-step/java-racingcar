package stage4.controller;

import stage4.domain.Car;
import stage4.domain.Cars;
import stage4.dto.InputValue;
import stage4.dto.ResultValue;
import stage4.service.CarService;
import stage4.view.InputView;
import stage4.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarApplication {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final CarService carService = new CarService();

    public static void main(String[] args) {
        final InputValue inputValue = inputView.input();
        final String[] carNames = inputValue.getCarNames();
        final int numberOfTries = inputValue.getTryNum();

        final Cars resultsOfCars = carService.startRace(carNames, numberOfTries);

        final int numberOfCars = carNames.length;
        resultView.printResult(numberOfCars, formatCarListToResultValueList(resultsOfCars));

        final Cars lastRacingResults = resultsOfCars.getLastRacingResults(numberOfCars);
        final Cars winners = carService.checkWinner(lastRacingResults);
        resultView.printWinner(formatCarListToResultValueList(winners));
    }

    private static List<ResultValue> formatCarListToResultValueList(Cars cars) {
        List<ResultValue> resultValueList = new ArrayList<>();
        final List<Car> carList = cars.getCars();
        for (Car car : carList) {
            resultValueList.add(ResultValue.formatCarToResultValue(car));
        }
        return resultValueList;
    }
}
