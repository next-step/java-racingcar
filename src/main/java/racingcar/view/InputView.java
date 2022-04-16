package racingcar.view;

import java.util.Scanner;

public final class InputView {
    private static final String CAR_INPUT_LABEL = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String ROUND_INPUT_LABEL = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String inputCarsInfo() {
        System.out.println(CAR_INPUT_LABEL);
        return SCANNER.nextLine();
    }

    public static int inputRound() {
        System.out.println(ROUND_INPUT_LABEL);
        return SCANNER.nextInt();
    }
}
