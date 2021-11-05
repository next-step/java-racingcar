package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ASK_CREATE_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_TRYCOUNT = "시도할 횟수는 몇 회 인가요?";
    private static final String ENTER_NUMBER = "숫자를 입력 하세요.";

    private InputView() {
    }

    public static int askCreateCarCount() {
        System.out.println(ASK_CREATE_CAR_COUNT);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(ENTER_NUMBER);
            return askCreateCarCount();
        }
    }

    public static int askTryCount() {
        System.out.println(ASK_TRYCOUNT);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(ENTER_NUMBER);
            return askTryCount();
        }
    }
}
