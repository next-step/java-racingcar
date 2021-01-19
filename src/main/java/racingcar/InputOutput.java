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
}
