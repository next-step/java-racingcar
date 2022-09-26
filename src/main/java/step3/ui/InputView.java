package step3.ui;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_TITLE_CAR_NUMBER = "자동차 대수는 몇대 인가요?";
    private static final String INPUT_TITLE_TRY_NUMBER = "시도할 회수는 몇 회 인가요?";

    public int inputCarNumber() {
        System.out.println(INPUT_TITLE_CAR_NUMBER);
        return scanner.nextInt();
    }

    public int inputTryNumber() {
        System.out.println(INPUT_TITLE_TRY_NUMBER);
        int n = scanner.nextInt();
        System.out.println();
        return n;
    }
}
