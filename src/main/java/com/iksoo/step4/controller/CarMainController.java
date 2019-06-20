package com.iksoo.step4.controller;

import com.iksoo.step4.model.Car;
import com.iksoo.step4.model.Cars;
import com.iksoo.step4.model.JudgeRacingWinners;
import com.iksoo.step4.view.CarInputData;
import com.iksoo.step4.view.CarOutputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarMainController {
    private static Random random = new Random();

    public static void main(String[] args) {
        Cars cars = new Cars(initiateRace());
        List<String> winnersName = JudgeRacingWinners.judgeRacingWinners(cars.getCars());
        CarOutputData.printFinalResult(cars.getCars(), winnersName);
    }

    public static List<Car> initiateRace() {
        String[] carNames = CarInputData.inputCarNames().split(",");
        int tryOfNumbers = CarInputData.inputTryOfNumber();

        CarOutputData.printRacingStart();

        return initiateCar(carNames, tryOfNumbers);
    }

    public static List<Car> initiateCar(String[] carNames, int tryOfNumbers) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], tryOfNumbers));
        }

        return cars;
    }

    public static int getRandom() {
        return random.nextInt(10);
    }
}
