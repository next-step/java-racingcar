package racingStep3;

import java.util.Scanner;

public class InputView {

    public static int inputData(String msg) {
        System.out.println(msg);

        Scanner scanner = new Scanner(System.in);
        String inValue = scanner.nextLine();
        checkValue(inValue);

        return Integer.parseInt(inValue);
    }

    private static void checkValue(String value) {
        Validation.numberCheck(value);
        Validation.validInputData(value);
    }
}
