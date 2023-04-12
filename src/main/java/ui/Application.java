package ui;

import car_racing.CarRacing;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        InputView.askForCarSize();
        carRacing.initCars(InputView.getCarSize());
        InputView.askForTrySize();
        int trySize = InputView.getTrySize();
        run(carRacing,trySize);
    }

    private static void run(CarRacing carRacing, int trySize) {
        for (int i = 0; i < trySize; i++) {
            carRacing.moveCars();
            ResultView.printMovingOfCars(carRacing.getCars());
            System.out.println();
        }
    }
}
