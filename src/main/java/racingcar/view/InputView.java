package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NUMBER_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println(INPUT_NUMBER_OF_CAR_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputRoundNumber() {
        System.out.println(INPUT_ROUND_MESSAGE);
        return scanner.nextInt();
    }
}
