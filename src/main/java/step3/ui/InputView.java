package step3.ui;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private static final String INPUT_TITLE_CAR_NUMBER = "자동차 대수는 몇대 인가요?";
    private static final String INPUT_TITLE_TRY_NUMBER = "시도할 회수는 몇 회 인가요?";
    static final String INPUT_ERROR_MSG = "숫자 형식만 입력할 수 있습니다.";

    public InputView(Scanner scanner) {
        this.scanner =  scanner;
    }
    public int inputCarNumber() {
        System.out.println(INPUT_TITLE_CAR_NUMBER);
        return inputInt();
    }

    public int inputTryNumber() {
        System.out.println(INPUT_TITLE_TRY_NUMBER);
        int n = inputInt();
        System.out.println();
        return n;
    }

    int inputInt() {
        try {
            return scanner.nextInt();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(INPUT_ERROR_MSG);
        }
    }
}
