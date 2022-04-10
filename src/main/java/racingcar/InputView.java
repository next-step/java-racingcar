package racingcar;

import java.util.Scanner;

public class InputView {
    private static final String CAR_INPUT_LABEL = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_INPUT_LABEL = "시도할 횟수는 몇 회 인가요?";
    private final int number;
    private final int round;

    public InputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CAR_INPUT_LABEL);
        this.number = scanner.nextInt();
        System.out.println(ROUND_INPUT_LABEL);
        this.round = scanner.nextInt();
    }

    public int number() {
        return number;
    }

    public int round() {
        return round;
    }
}
