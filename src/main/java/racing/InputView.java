package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputtedCarCount() {

        System.out.println("자동차 대수는 몇 대 인가요?");
        while (true) {
            Integer result = getInputtedNumber();
            if (result != null) return result;
        }
    }

    public int inputtedTryCount() {

        System.out.println("시도할 회수는 몇 회 인가요?");
        while (true) {
            Integer result = getInputtedNumber();
            if (result != null) return result;
        }
    }

    public void closeScanner() {
        scanner.close();
    }

    private Integer getInputtedNumber() {
        try {
            int result = scanner.nextInt();
            scanner.nextLine();     // 버퍼 제거
            return result;
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
            scanner.nextLine();     // 버퍼 제거
        }
        return null;
    }
}
