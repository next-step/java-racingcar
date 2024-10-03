package race;

import java.util.Scanner;

public class InputView {
    public static final String CAR_COUNT_REQUEST_STATEMENT = "자동차 대수는 몇 대 인가요? (2 이상의 숫자 입력)";
    public static final String RANDOM_STOP_OR_GO_COUNT_REQUEST_STATEMENT = "시도할 회수는 몇 회 인가요? (1 이상의 숫자 입력)";
    public static final int MIN_CAR_COUNT = 2;
    public static final int MIN_RANDOM_STOP_OR_GO_COUNT = 1;

    public static RaceInput inputCarCountAndGameCount() {
        int carCount = 0;
        int randomStopOrGoCount = 0;

        while (carCount < MIN_CAR_COUNT || randomStopOrGoCount < MIN_RANDOM_STOP_OR_GO_COUNT) {
            System.out.println(CAR_COUNT_REQUEST_STATEMENT);
            carCount = getInput();
            System.out.println(RANDOM_STOP_OR_GO_COUNT_REQUEST_STATEMENT);
            randomStopOrGoCount = getInput();
        }

        return new RaceInput(carCount, randomStopOrGoCount);
    }

    private static int getInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }
}
