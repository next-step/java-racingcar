package com.racing;

import com.racing.domain.Car;
import com.racing.ui.InputView;
import com.racing.ui.ResultView;
import com.racing.utils.CarHelper;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.getCarName();
        int tryNumber = InputView.getTryNumber();

        List<String> validCarNames = CarHelper.splitCarName(carNames);

        List<Car> carList = createCars(validCarNames);
        runRace(carList, tryNumber);
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(0, carName));
        }

        return carList;
    }

    private static void runRace(List<Car> carList, int tryNumber) {
        ResultView.printStartMessage();
        for (int i = 0; i < tryNumber; i++) {
            moveAllCars(carList);
            ResultView.printRoundResult(i + 1, carList);
        }
    }

    private static void moveAllCars(List<Car> carList) {
        for (Car car : carList) {
            car.move();
        }
    }
}