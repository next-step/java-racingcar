package refactoringracingcar.main;

import refactoringracingcar.controller.CarController;

public class Main {
    public static void main(String[] args) {
        CarController carController = new CarController();
        System.out.println(carController.startGame());
    }
}
