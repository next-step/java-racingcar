package racingcar;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int readCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return readInt();
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return readInt();
    }

    private int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다", e);
        }
    }
}
