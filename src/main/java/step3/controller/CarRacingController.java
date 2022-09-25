package step3.controller;

import step3.model.Car;
import step3.model.Try;
import step3.util.numberGenerator.NumberGenerator;
import step3.util.numberGenerator.RandomNumberGenerator;
import step3.view.InputView;
import step3.view.InputViewImpl;
import step3.view.ResultView;
import step3.view.ResultViewImpl;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacingController {

    public void racingGame() {
        ResultView resultView = new ResultViewImpl();
        InputView inputView = new InputViewImpl();

        int numberOfCars = inputView.askNumberOfCars();
        Try numberOfTrys = new Try(inputView.askNumberOfTrys());

        List<Car> carList = IntStream.range(0, numberOfCars).mapToObj(i -> new Car()).collect(Collectors.toCollection(ArrayList::new));

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < numberOfTrys.getTryCnt(); i++) {
            racing(numberGenerator, carList);
            resultView.drawResult(carList);
        }
    }

    private void racing(NumberGenerator numberGenerator, List<Car> list) {
        for (Car car : list) {
            car.decideMoveOrStop(numberGenerator);
        }
    }
}
