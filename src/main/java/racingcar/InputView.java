package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_CAR_NUMBER = "자동차 대수는 몇대입니까?";
    private static final String MESSAGE_TRY_NUMBER = "시도할 회수 몇회입니까?";
    private static final String MESSAGE_ERROR_NUMBER = "숫자만 가능합니다";
    private Scanner scanner;

    public InputView (Scanner scanner) {
        this.scanner = scanner;
    }

    public int getMessageCarNumber () {
        System.out.println(MESSAGE_CAR_NUMBER);
        return scanner.nextInt();
    }

    public int getMessageTryNumber () {
        System.out.println(MESSAGE_TRY_NUMBER);
        return scanner.nextInt();
    }

    public Integer getScanner () {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NUMBER);
        }
    }
}

