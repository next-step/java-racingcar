package step3.controller;

import step3.model.Car;
import step3.model.Cars;
import step3.model.Try;
import step3.util.numberGenerator.NumberGenerator;
import step3.util.numberGenerator.RandomNumberGenerator;
import step3.view.ResultView;
import step3.view.ResultViewImpl;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacingController {

    private static final int MAX_BOUND_NUMBER = 10;

    public void racingGame(int numberOfCars, int numberOfTrys) {
        if(numberOfCars < 1 || numberOfTrys < 1) throw new RuntimeException("자동차 댓수 또는 시도 횟수는 적어도 양수여야 합니다.");

        ResultView resultView = new ResultViewImpl();
        Try trys = new Try(numberOfTrys);
        Cars cars = new Cars(IntStream.range(0, numberOfCars).mapToObj(i -> new Car()).collect(Collectors.toCollection(ArrayList::new)));
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < trys.getTryCnt(); i++) {
            racing(numberGenerator, cars);
            resultView.drawResult(cars);
        }
    }

    private void racing(NumberGenerator numberGenerator, Cars cars) {
        for (Car car : cars.getCars()) {
            car.decideMoveOrStop(numberGenerator.generate(MAX_BOUND_NUMBER));
        }
    }
}
