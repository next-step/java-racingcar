package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String MESSAGE_ASK_HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_ASK_HOW_MANY_TIMES = "시도할 회수는 몇 회 인가요?";
    private static final String MESSAGE_PLEASE_ENTER_AGAIN = "다시 입력 해주세요.";
    private static final String MESSAGE_ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";

    private InputView() {

    }

    public static int askHowManyCars() {
        System.out.println(MESSAGE_ASK_HOW_MANY_CARS);
        return scanInputNumber();
    }

    public static int askHowManyTimes() {
        System.out.println(MESSAGE_ASK_HOW_MANY_TIMES);
        return scanInputNumber();
    }

    public static String askCarNames() {
        System.out.println(MESSAGE_ASK_CAR_NAMES);
        return scanInputString();
    }

    private static String scanInputString() {

        try {
            String line = SCANNER.nextLine();
            validateString(line);
            return line;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(MESSAGE_PLEASE_ENTER_AGAIN);
        }
        return scanInputString();
    }

    private static void validateString(String line) {
        if (line.trim().length() == 0) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static int scanInputNumber() {
        try {
            int number = SCANNER.nextInt();
            validateNumber(number);
            return number;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(MESSAGE_PLEASE_ENTER_AGAIN);
        }
        return scanInputNumber();
    }

    private static void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0이하는 입력할 수 없습니다.");
        }
    }
}
