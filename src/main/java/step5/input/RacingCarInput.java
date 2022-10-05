package step5.input;

import java.util.Scanner;

public class RacingCarInput {

    private static final String CAR_NAME_DELIMITER = ",";

    public static String[] carNames() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(CAR_NAME_DELIMITER);
    }

    public static int tryCount() {
        Scanner scanner = new Scanner(System.in);
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
