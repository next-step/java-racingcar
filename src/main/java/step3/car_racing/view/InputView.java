package step3.car_racing.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String VALIDATION_MESSAGE = "양수만 입력할 수 있습니다. 다시 입력해 주세요.";
    private static final String CAR_SIZE_REQUEST_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String RACING_SIZE_REQUEST_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Integer ZERO = 0;

    private InputView() {
        // 인스턴스화 방지
        throw new AssertionError();
    }

    public int inputCarSize() {
        System.out.println(CAR_SIZE_REQUEST_MESSAGE);
        return validateInput();
    }

    public int inputRacingSize() {
        System.out.println(RACING_SIZE_REQUEST_MESSAGE);
        return validateInput();
    }

    private int validateInput() {
        String input = SCANNER.next();

        while (!validatePositive(input)) {
            System.out.println(VALIDATION_MESSAGE);
            input = SCANNER.next();
        }

        return Integer.parseInt(input);
    }

    private boolean validatePositive(String input) {
        try {
            return Integer.parseInt(input) > ZERO;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
