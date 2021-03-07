package step3.ui;

import java.util.Scanner;

import static java.lang.System.out;
import static step3.util.Constants.IS_NULL_OR_BLANK_EXCEPTION;
import static step3.util.Validator.isNullAndIsBlank;

/**
 * 사용자의 입력을 받기 위한 클래스
 */
public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    // 사용자 입력
    public int requestUserInput(String message) {

        out.println(message);
        String number = scanner.nextLine();

        if(isNullAndIsBlank(number)) {
            throw new IllegalArgumentException(IS_NULL_OR_BLANK_EXCEPTION);
        }
        return parseInteger(message, number);
    }

    // 사용자 입력 값이 숫자가 아닌 경우 재입력 처리
    private int parseInteger(String message, String number) {
        int parseInt;

        try {
            parseInt = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return requestUserInput(message);
        }

        return parseInt;
    }
}
