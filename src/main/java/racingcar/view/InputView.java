package racingcar.view;

import racingcar.controller.InputValidatorController;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);

    public static String inputCarsName() {
        String carsName = null;
        boolean isValidCarsName = false;
        while (!isValidCarsName) {
            carsName = scanner.next();
            isValidCarsName = InputValidatorController.validateCarsName(carsName);
        }
        return carsName;
    }

    public static int inputStages() {
        String stages = null;
        boolean isValidStages = false;
        while (!isValidStages) {
            stages = scanner.next();
            isValidStages = InputValidatorController.validateStages(stages);
        }
        return Integer.parseInt(stages);
    }


}
