package racingcar.ui;

import java.util.Scanner;

import static racingcar.ui.MotorRacingDisplay.display;

public class MotorRacingUserInputWithCounter {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String CAR_NAME_SPLIT_STR = ",";

    public static UserInputInfoWithCount input() {
        final int carCount = inputCarCount();
        final int tryCount = inputTryCount();
        return new UserInputInfoWithCount(carCount, tryCount);
    }

    private static int inputTryCount() {
        display("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private static int inputCarCount() {
        display("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

}
