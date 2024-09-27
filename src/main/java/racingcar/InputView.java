package racingcar;

import java.util.Scanner;

public class InputView {
    private static String INPUT_COUNT_OF_CAR_MSG = "자동차 대수는 몇 대 인가요?";
    private static String INPUT_TIMES_OF_RUN_MSG = "시도할 횟수는 몇회 인가요?";

    // 자동차 대수 입력
    public static int inputCountOfCar() {
        System.out.println(INPUT_COUNT_OF_CAR_MSG);
        return systemIn();
    }

    // 시도 횟수 입력
    public static int inputTimesOfRun() {
        System.out.println(INPUT_TIMES_OF_RUN_MSG);
        return systemIn();
    }

    private static int systemIn() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
