package racingcar;

import java.util.Scanner;

public class InputOutput {
    public static Scanner scanner = new Scanner(System.in);

    public static String inputCarsName() {
        String carsName = scanner.next();
        try {
            Validator.checkEmptyElement(carsName);
            Validator.checkLastValueComma(carsName);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
        return carsName;
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
