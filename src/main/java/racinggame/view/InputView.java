package racinggame.view;

import java.util.Scanner;
import racinggame.domain.Validator;

public class InputView {

    public static final String QUIT = "q";
    private static final String SEPARATOR = ",";

    private InputView() {}

    public static String inputCarNames() {
        System.out.printf("경주할 자동차 이름을 %s로 구분해서 입력하세요.(%d대 이상)\n", SEPARATOR,
                Validator.MINIMUM_PLAYER);
        return getInput();
    }

    public static String inputTrial() {
        System.out.print("시도 횟수를 입력해 주세요: ");
        return getInput();
    }

    public static String inputRestartCommand() {
        System.out.printf("게임이 종료되었습니다. (종료 = %s, 다시 시작 = 아무 키 입력)\n", QUIT);
        return getInput();
    }

    private static String getInput() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
