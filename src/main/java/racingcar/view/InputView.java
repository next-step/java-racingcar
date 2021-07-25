package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String MSG_CARS="자동차 대수는 몇 대 인가요?";
    private static final String MSG_ATTEMPTS="시도할 회수는 몇 회 인가요?";

    public int inputNumberOfCars() {
        System.out.println(MSG_CARS);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int inputNumberOfAttempts() {
        System.out.println(MSG_ATTEMPTS);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
