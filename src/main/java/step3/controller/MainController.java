package step3.controller;

import step3.model.Cars;
import step3.view.input.InputScanner;
import step3.view.output.OutputText;

public class MainController {

    public static void main(String[] args) {
        System.out.println(OutputText.CAR_COUNT_VIEW);
        String inputPlayerNames = InputScanner.scanStringInput();

        System.out.println(OutputText.CYCLE_COUNT_VIEW);
        int inputCycleCount = InputScanner.scanIntInput();
        System.out.println(OutputText.RESULT_TEXT);

        Cars cars = new Cars(inputPlayerNames);

        for (int i = 0; i < inputCycleCount; i++) {
            cars.runRace();
        }
        cars.sortWinners();
        System.out.println(cars.getGameResult());
    }
}
