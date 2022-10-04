package racingcar.view;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);
    private static final String NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    public static int numberOfCars() {
        System.out.println(NUMBER_OF_CARS);
        return sc.nextInt();
    }

    public static int numberOfAttempts() {
        System.out.println(NUMBER_OF_ATTEMPTS);
        return sc.nextInt();
    }
}
