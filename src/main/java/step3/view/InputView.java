package step3.view;

import step3.domain.UserInput;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static UserInput input() {
        final int carCount = inputCarCount();
        final int retry = inputRetryCount();

        return new UserInput(carCount, retry);
    }

    private static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        return SCANNER.nextInt();
    }

    private static int inputRetryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        return SCANNER.nextInt();
    }

}
