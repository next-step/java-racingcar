package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String QUESTION_OF_CARS = "자동자 대수는 몇 대 인가요?";
    private final static String QUESTION_OF_ATTEMPTS = "시도할 횟수는 몇 회 인가요?";

    public int inputCar() {
        System.out.println(QUESTION_OF_CARS);
        return SCANNER.nextInt();
    }

    public int inputAttempt() {
        System.out.println(QUESTION_OF_ATTEMPTS);
        return SCANNER.nextInt();
    }

}
