package racingcar;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int readCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return readNumber();
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return readNumber();
    }

    private int readNumber() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만 입력할 수 있습니다.");
        }
    }
}
