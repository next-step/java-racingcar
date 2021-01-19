package racingcar;

import java.util.Scanner;

public class InputOutput {
    public static Scanner scanner = new Scanner(System.in);

    public static String inputCarsName() {
        String carsName = null;
        boolean isValidCarsName = false;
        while (!isValidCarsName) {
            carsName = scanner.next();
            isValidCarsName = validateCarsName(carsName);
        }
        return carsName;
    }
    private static boolean validateCarsName(String carsName) {
        try {
            Validator.checkEmptyElement(carsName);
            Validator.checkLastValueComma(carsName);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static int inputStages() {
        String stages = null;
        boolean isValidStages = false;
        while (!isValidStages) {
            stages = scanner.next();
            isValidStages = validateStages(stages);
        }
        return Integer.parseInt(stages);
    }

    private static boolean validateStages(String stages) {
        try {
            Validator.checkNumber(stages);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
