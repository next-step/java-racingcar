package com.racing;

import com.racing.domain.Car;
import com.racing.ui.InputView;
import com.racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int carNumber = InputView.getCarNumber();
        int tryNumber = InputView.getTryNumber();

        List<Car> carList = createCars(carNumber);
        runRace(carList, tryNumber);
    }

    private static List<Car> createCars(int carNumber) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car());
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