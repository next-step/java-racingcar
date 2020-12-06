package racing.view;

import dto.Request;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_REQUEST = "자동차 대수는 몇 대 인가요?";

    private static final String ROUND_REQUEST = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static Request input() {
        return new Request(inputCarCount(), inputRound());
    }

    private static int inputCarCount() {
        System.out.println(CAR_COUNT_REQUEST);
        return scanner.nextInt();
    }

    private static int inputRound() {
        System.out.println(ROUND_REQUEST);
        return scanner.nextInt();
    }
}
