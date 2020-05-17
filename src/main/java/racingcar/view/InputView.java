package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_DELIMITER = ",";

    private InputView() {
    }

    public static int askTime() {
        System.out.println("이동 횟수?");
        return SCANNER.nextInt();
    }

    public static String[] askCarNames() {
        System.out.println("자동차 이름?");
        String names = SCANNER.next();
        return names.split(NAME_DELIMITER);
    }

}
