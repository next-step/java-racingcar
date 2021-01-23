package domain;

import view.InputView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.inputCarsName();
        ArrayList<Car> carsList = Car.asCarsList(carNames);
        int stages = InputView.inputStages();

        Racing racing = new Racing(carsList, stages);
        racing.start();
    }
}