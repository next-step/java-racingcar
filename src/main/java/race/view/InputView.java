package race.view;

import java.util.Scanner;

public class InputView {

    private static final String INVALID_INPUT_MESSAGE_FORMAT = "잘못된 입력값입니다. 다시 입력해주세요. %s";

    public static int requestCountOfTrial() {
        try {
            System.out.println("시도할 회수는 몇 회 인가요?");
            return inputNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCountOfTrial();
        }
    }

    public static String requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return inputCarNames();
    }

    public static int requestCars() {
        try {
            System.out.println("자동차 대수는 몇 대 인가요?");
            return inputNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCars();
        }
    }

    private static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return toPositiveInt(value);
    }

    private static String inputCarNames() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int toPositiveInt(String text) {
        try {
            int number = Integer.parseInt(text);
            if (number < 0) {
                throw new IllegalArgumentException(String.format(INVALID_INPUT_MESSAGE_FORMAT, text));
            }
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_MESSAGE_FORMAT, text));
        }
    }
}
