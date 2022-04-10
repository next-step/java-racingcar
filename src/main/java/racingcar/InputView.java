package racingcar;

import java.util.Scanner;

public class InputView {

    public static final String INPUT_CAR_COUNT_MESSAGE = "경주에 참여할 자동차 대수를 입력하세요.";
    public static final String INPUT_ROUND_COUNT_MESSAGE = "총 라운드 수를 입력하세요.";
    private final Scanner scanner = new Scanner(System.in);

    public int inputCarCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public int inputRoundCount() {
        System.out.println(INPUT_ROUND_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
