package step5.controller;


import step5.domain.CarRacing;
import step5.utils.RandomGenerator;
import step5.view.InputView;
import step5.view.ResultView;

public class Main {

    public static void main(String[] args) {
        String drivers = InputView.getDrivers();
        int countOfCarRacing = InputView.getCountOfCarRacing();

        CarRacing carRacing = new CarRacing(drivers.split(","));

        ResultView.printStart();
        ResultView.printCarsMove(carRacing.getCurrentStatus());

        for (int i=0; i<countOfCarRacing; i++) {
            carRacing.moveProgress(new RandomGenerator());
            ResultView.printCarsMove(carRacing.getCurrentStatus());
        }
        ResultView.printWinner(carRacing.getWinner());
    }
}
