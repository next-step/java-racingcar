package racingcar.service.util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputString(String msg) {
        System.out.println(msg);

        return scanner.nextLine();
    }

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
