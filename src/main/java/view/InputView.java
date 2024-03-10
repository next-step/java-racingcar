package view;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static int promptForCarCount() {
        return promptForCount("자동차 대수는 몇 대인가요?");
    }

    public static int promptForMoveCount() {
        return promptForCount("시도할 회수는 몇 회 인가요?");
    }

    private static int promptForCount(String showMessage) {
        System.out.println(showMessage);
        try {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input < 1) {
                throw new IllegalArgumentException("1 이상의 양수만 입력할 수 있습니다.");
            }
            return input;
        } catch (Exception e) {
            String message = e.getMessage();
            throw new IllegalArgumentException(message == null ? "잘못된 입력 값입니다." : message, e);
        }
    }
}
