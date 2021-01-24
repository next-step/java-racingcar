package racingcar.controller;

import racingcar.Car;
import racingcar.Racing;
import racingcar.view.Input;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String carNames = Input.inputCarsName();
        ArrayList<Car> carsList = Car.asCarsList(carNames);
        int stages = Input.inputStages();

        Racing racing = new Racing(carsList, stages);
        racing.start();
    }
}