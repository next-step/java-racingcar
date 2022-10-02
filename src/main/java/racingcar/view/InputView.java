package racingcar.view;

import java.util.Scanner;

public final class InputView {

    private InputView() {
        throw new AssertionError("No instance");
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final String HOW_MANY_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_TIME = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static int askNumberOfCar() {
        System.out.println(HOW_MANY_CAR);
        return scanner.nextInt();
    }

    public static int askTimes() {
        System.out.println(HOW_MANY_TIME);
        return scanner.nextInt();
    }

    public static String askName() {
        System.out.println(CAR_NAME);
        return scanner.nextLine();
    }
}
