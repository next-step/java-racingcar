package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public int inputRoundCount() {
        System.out.println(ROUND_COUNT_MESSAGE);
        return scanner.nextInt();
    }

}
