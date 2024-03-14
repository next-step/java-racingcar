package racingcar;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final NumberValidator validator = new NumberValidator();

    public static String numberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextLine();
    }

    public static String tryCntInput() {
        System.out.println("시도할 횟 수는 몇 회 인가요?");
        return SCANNER.nextLine();
    }

    public static int inputNumber(String value) {
        return numberCheck(value);
    }

    public static Integer numberCheck(String value) {
        validator.numericCheck(value);
        validator.nullCheck(value);
        return Integer.parseInt(value);
    }
}
