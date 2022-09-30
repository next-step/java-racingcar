package step3.ui;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_TITLE_CAR_NUMBER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TITLE_TRY_NUMBER = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_ERROR_MSG = "숫자 형식만 입력할 수 있습니다.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputString() {
        System.out.println(INPUT_TITLE_CAR_NUMBER);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public int inputTryNumber() {
        System.out.println(INPUT_TITLE_TRY_NUMBER);

        try {
            int n = scanner.nextInt();
            System.out.println();
            return n;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(INPUT_ERROR_MSG);
        }
    }
}
