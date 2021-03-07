package step3.ui;

import java.util.Scanner;

import static java.lang.System.out;
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
    public int getUserInput(String message) {

        out.println(message);
        String number = scanner.nextLine();

        if(isNullAndIsBlank(number)) {
            throw new IllegalArgumentException("입력한 값이 존재하지 않거나 공백이 존재합니다.");
        }
        return getUserInput(message, number);
    }

    // 사용자 입력 값이 숫자가 아닌 경우 재입력 처리
    private int getUserInput(String message, String number) {
        int parseInt;

        try {
            parseInt = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return getUserInput(message);
        }

        return parseInt;
    }
}
