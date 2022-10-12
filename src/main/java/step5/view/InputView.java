package step5.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";
    public static final Scanner scanner = new Scanner(System.in);

    public static String[] carNames() {
        return scanner.nextLine().split(CAR_NAME_DELIMITER);
    }

    public static int tryCount() {
        int tryCount = scanner.nextInt();
        validateTryCount(tryCount);
        return tryCount;
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("음수나 0은 입력할 수 없습니다");
        }
    }
}
