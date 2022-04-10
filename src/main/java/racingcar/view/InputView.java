package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static final String NUMBER_OF_CARS_PROMPT = "자동차 대수는 몇 대 인가요?";
    public static final String RACING_TIMES_PROMPT = "시도할 회수는 몇 회 인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    // 기본 생성자가 만들어지는 것을 막는다(인스턴스화방지용.)
    private InputView() {
        throw new AssertionError();
    }

    public static int inputNumberOfCars() {
        System.out.println(NUMBER_OF_CARS_PROMPT);
        return SCANNER.nextInt();
    }

    public static int inputNumberOfAttempts() {
        System.out.println(RACING_TIMES_PROMPT);
        return SCANNER.nextInt();
    }
}
