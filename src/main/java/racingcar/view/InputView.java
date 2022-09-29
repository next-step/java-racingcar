package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_DESCRIPTION = "자동차 대수는 몇 대 인가요?";
    private static final String PLAY_DESCRIPTION = "시도할 횟수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getCarCount() {
        System.out.println(CAR_DESCRIPTION);
        return getZeroOrPositiveInteger();
    }

    public int getPlayCount() {
        System.out.println(PLAY_DESCRIPTION);
        return getZeroOrPositiveInteger();
    }

    private int getZeroOrPositiveInteger() {
        int intValue = scanner.nextInt();
        if(intValue < 0) {
            throw new RuntimeException("0 이상의 숫자를 입력해주세요.");
        }

        return intValue;
    }

}
