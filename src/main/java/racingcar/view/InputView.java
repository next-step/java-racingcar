package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ASK_CREATE_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_TRYCOUNT = "시도할 횟수는 몇 회 인가요?";
    private static final String ENTER_NUMBER = "숫자를 입력 하세요.";

    private InputView() {
    }

    public static String askCreateCarNames() {
        System.out.println(ASK_CREATE_CAR_NAMES);
            return SCANNER.nextLine();
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
