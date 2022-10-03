package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MAKE_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String PLAY_COUNT = "시도할 회수는 몇 회 인가요?";

    public int getCarCount() {
        System.out.println(MAKE_CAR_COUNT);
        return getPositiveIntValue();
    }

    private int getPositiveIntValue() {
        int intValue = scanner.nextInt();
        if (intValue < 0) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력하세요.");
        }

        return intValue;
    }

    public int getPlayCount() {
        System.out.println(PLAY_COUNT);
        return getPositiveIntValue();
    }
}
