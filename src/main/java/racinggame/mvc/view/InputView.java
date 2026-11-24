package racinggame.mvc.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String INVALID_TRY_COUNT_MESSAGE = "숫자만 입력해야 합니다.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getCarNames() {
        System.out.println(CAR_NAMES_PROMPT);
        return SCANNER.nextLine();
    }

    public static int getTryNo() {
        System.out.println(TRY_COUNT_PROMPT);
        String input = SCANNER.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE, e);
        }
    }
}
