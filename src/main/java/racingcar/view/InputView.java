package racingcar.view;

import java.util.Scanner;

public final class InputView {
    private static final String CAR_INPUT_LABEL = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_INPUT_LABEL = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

     private InputView() {
         throw new AssertionError();
    }

    public static int inputNumber() {
        System.out.println(CAR_INPUT_LABEL);
        return SCANNER.nextInt();
    }

    public static int inputRound() {
        System.out.println(ROUND_INPUT_LABEL);
        return SCANNER.nextInt();
    }
}
