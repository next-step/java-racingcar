package step3;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int readCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return readInt();
    }

    public static int readTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return readInt();
    }

    private static int readInt() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }
}
