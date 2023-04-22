package step3;

import step3.controller.CarController;
import step3.view.InputView;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String[] cars = inputView.inputCars();
        int numberOfMoves = inputView.inputNumberOfMoves();

        CarController carController = new CarController(cars, numberOfMoves);
        carController.start();
    }
}
