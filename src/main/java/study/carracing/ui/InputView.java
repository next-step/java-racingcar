package study.carracing.ui;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static Scanner sc = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        int carCount = sc.nextInt();
        validateInput(carCount);
        return carCount;
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        int tryCount = sc.nextInt();
        validateInput(tryCount);
        return tryCount;
    }

    private static void validateInput(int input) {
        if (isNotNumberOrNegative(input)) {
            throw new IllegalArgumentException("숫자 이외의 값 또는 음수가 입력됐습니다." + input);
        }
    }

    private static boolean isNotNumberOrNegative(int input) {
        return !NUMBER_PATTERN.matcher(String.valueOf(input)).matches();
    }
}
