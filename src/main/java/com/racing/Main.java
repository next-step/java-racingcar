package com.racing;

import com.racing.domain.Car;
import com.racing.domain.Cars;
import com.racing.ui.InputView;
import com.racing.ui.ResultView;
import com.racing.utils.CarHelper;
import com.racing.utils.RacingHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.getCarName();
        int tryNumber = InputView.getTryNumber();

        List<String> validCarNames = CarHelper.splitCarName(carNames);

        Cars cars = createCars(validCarNames);

        // 리팩토링 단계에서 임시로 선언했습니다!
        List<Car> carList = cars.getCarList();
        runRace(carList, tryNumber);

        List<Car> winners = CarHelper.determineWinners(carList);
        ResultView.printWinners(winners);
    }

    private static Cars createCars(List<String> carNames) {
        Cars cars = new Cars();

        for (String carName : carNames) {
            cars.addCars(new Car(0, carName));
        }

        return cars;
    }

    private static void runRace(List<Car> carList, int tryNumber) {
        ResultView.printStartMessage();
        for (int i = 0; i < tryNumber; i++) {
            moveAllCars(carList);
            ResultView.printRoundResult(i + 1, carList);
        }
    }

    private static void moveAllCars(List<Car> carList) {
        RacingHelper racingHelper = new RacingHelper();

        for (Car car : carList) {
            car.move(racingHelper.shouldMove());
        }
    }
}