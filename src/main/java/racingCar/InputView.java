package racingCar;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대인가요?";
    private static final String INPUT_TRY_RACING_COUNT_MESSAGE = "시도할 회수는 몇 회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static int initializeCarCount(){
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static int initializeTryRacingCount(){
        System.out.println(INPUT_TRY_RACING_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
