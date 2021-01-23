package domain;

import view.InputOutput;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String carNames = InputOutput.inputCarsName();
        ArrayList<Car> carsList = Car.asCarsList(carNames);
        int stages = InputOutput.inputStages();

        Racing racing = new Racing(carsList, stages);
        racing.start();
    }
}