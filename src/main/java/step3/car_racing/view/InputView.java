package step3.car_racing.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String VALIDATION_MESSAGE = "양수만 입력할 수 있습니다. 다시 입력해 주세요.";

    public int input() {
        return validateInput();
    }

    private int validateInput() {
        while (!SCANNER.hasNextInt() || SCANNER.nextInt() < 0) {
            System.out.println(VALIDATION_MESSAGE);
            SCANNER.next();
        }
        return SCANNER.nextInt();
    }
}
