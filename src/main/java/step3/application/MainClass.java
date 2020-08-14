package step3.application;

import step3.logic.Cars;
import step3.view.input.InputScanner;
import step3.view.output.OutputText;

public class MainClass {

    public static void main(String[] args) {
        System.out.println(OutputText.CAR_COUNT_VIEW);
        String inputPlayerNames = InputScanner.scanStringInput();

        System.out.println(OutputText.CYCLE_COUNT_VIEW);
        int inputCycleCount = InputScanner.scanIntInput();
        System.out.println(OutputText.RESULT_TEXT);

        Cars cars = new Cars(inputPlayerNames);

        for (int i = 0; i < inputCycleCount; i++) {
            cars.runRace();
            System.out.println();
        }

        System.out.println(cars.sortWinners());
    }
}
