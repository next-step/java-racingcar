package racinggame.view;

import static racinggame.exception.ExceptionBaseMessage.EXCEEDED_RETRIES_EXCEPTION_MESSAGE;

import java.util.Scanner;
import racinggame.domain.Validator;
import racinggame.exception.InputBlankException;

public class InputView {

    public static final String QUIT = "q";
    private static final String SEPARATOR = ",";
    private static final String BLANK = "\\s+";
    private static final String EMPTY_STRING = "";

    private static int tryCount = 1;

    private InputView() {}

    public static String inputCarNames() {
        System.out.printf("경주할 자동차 이름을 %s로 구분해서 입력하세요.(%d대 이상)\n", SEPARATOR, Validator.MINIMUM_PLAYER);
        return getInput();
    }

    public static String inputTrial() throws IllegalAccessException {
        System.out.print("시도 횟수를 입력해 주세요: ");
        String input = removeBlank(getInput());

        try {
            Validator.checkIsBlank(input);
            Validator.isNumber(input);
        } catch (InputBlankException | NumberFormatException e) {
            System.out.println(e.getMessage());
            input = retryInputTrial();
        }

        return input;
    }

    private static String removeBlank(final String trial) {
        return trial.replaceAll(BLANK, EMPTY_STRING);
    }

    private static String retryInputTrial() throws IllegalAccessException {
        if (tryCount > 5) {
            throw new IllegalAccessException(EXCEEDED_RETRIES_EXCEPTION_MESSAGE);
        }
        tryCount++;
        return InputView.inputTrial();
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
