package race;

import java.util.Scanner;

public class InputView {


    public static final String CAR_COUNT_REQUEST_STATEMENT = "자동차 대수는 몇 대 인가요?";
    public static final String RANDOM_STOP_OR_GO_COUNT_REQUEST_STATEMENT = "시도할 회수는 몇 회 인가요?";

    public static RaceInput inputCarCountAndRandomStopOrGoCount() {
        System.out.println(CAR_COUNT_REQUEST_STATEMENT);
        String carCount = getInput();

        System.out.println(RANDOM_STOP_OR_GO_COUNT_REQUEST_STATEMENT);
        String randomStopOrGoCount = getInput();

        return new RaceInput(carCount, randomStopOrGoCount);
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
