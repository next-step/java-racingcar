package ui;

import car_racing.CarRacing;
import car_racing.InputView;
import car_racing.ResultView;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        InputView inputView = new InputView();
        inputView.saveInputs();
        carRacing.initCars(inputView.carSize);
        run(carRacing, inputView);
    }

    private static void run(CarRacing carRacing, InputView inputView) {
        for (int i = 0; i < inputView.trySize; i++) {
            carRacing.moveCars();
            ResultView.printMovingOfCars(carRacing.getCars());
            System.out.println();
        }
    }
}
