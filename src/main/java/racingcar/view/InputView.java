package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String HOW_MANY_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_TIME = "시도할 회수는 몇 회 인가요?";

    public static int askNumberOfCar() {
        System.out.println(HOW_MANY_CAR);
        return scanner.nextInt();
    }

    public static int askTimes() {
        System.out.println(HOW_MANY_TIME);
        return scanner.nextInt();
    }
}
