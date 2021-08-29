package stage4.controller;

import stage4.domain.Car;
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

        final List<Car> resultsOfCars = carService.startRace(carNames, numberOfTries);

        final int numberOfCars = carNames.length;
        resultView.printResult(numberOfCars, formatCarListToResultValueList(resultsOfCars));

        final List<Car> lastRacingResults = getLastRacingResults(numberOfCars, resultsOfCars, resultsOfCars.size());
        final List<Car> winners = carService.checkWinner(lastRacingResults);
        resultView.printWinner(formatCarListToResultValueList(winners));
    }

    private static List<Car> getLastRacingResults(int numberOfCars, List<Car> resultOfCars, int lastIndex) {
        return resultOfCars.subList(lastIndex - numberOfCars, lastIndex);
    }

    private static List<ResultValue> formatCarListToResultValueList(List<Car> carList) {
        List<ResultValue> resultValueList = new ArrayList<>();
        for (Car car : carList) {
            resultValueList.add(ResultValue.formatCarToResultValue(car));
        }
        return resultValueList;
    }
}
