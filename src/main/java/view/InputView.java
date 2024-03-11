package view;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static String promptForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.");
        }
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
            return scanner.nextInt();
        } catch (Exception e) {
            String message = e.getMessage();
            throw new IllegalArgumentException(message == null ? "잘못된 입력 값입니다." : message, e);
        }
    }
}
