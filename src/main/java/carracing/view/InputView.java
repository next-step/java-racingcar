package carracing.view;

import java.util.Scanner;

/**
 * 자동차 경주를 위한 정보를 입력받는 콘솔
 */
public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_TRIALS_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static int readNumberOfTrials() {
        System.out.println(NUMBER_OF_TRIALS_INPUT_MESSAGE);
        return Integer.parseInt(readString());
    }

    public static String readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        return readString();
    }

    private static String readString() {
        return SCANNER.nextLine();
    }
}
