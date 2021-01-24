package racingcar.view;

import racingcar.Validator;
import java.util.Scanner;

public class Input {
    public static Scanner scanner = new Scanner(System.in);

    public static String inputCarsName() {
        String carsName = null;
        boolean isValidCarsName = false;
        while (!isValidCarsName) {
            carsName = scanner.next();
            isValidCarsName = Validator.validateCarsName(carsName);
        }
        return carsName;
    }

    public static int inputStages() {
        String stages = null;
        boolean isValidStages = false;
        while (!isValidStages) {
            stages = scanner.next();
            isValidStages = Validator.validateStages(stages);
        }
        return Integer.parseInt(stages);
    }
}
