package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    public static String getCarCount() {
        return printQuestion(CAR_COUNT);
    }

    public static String getTryCount() {
        return printQuestion(TRY_COUNT);
    }

    private static String printQuestion(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }
}
