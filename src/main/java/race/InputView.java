package race;

import java.util.Scanner;

public class InputView {
    public static final String CAR_COUNT_REQUEST_STATEMENT = "자동차 대수는 몇 대 인가요? (2 이상의 숫자 입력)";
    public static final String GAME_COUNT_REQUEST_STATEMENT = "시도할 회수는 몇 회 인가요? (1 이상의 숫자 입력)";

    public static int inputCarCount() {
        System.out.println(CAR_COUNT_REQUEST_STATEMENT);
        return getInput();
    }

    public static int inputGameCount() {
        System.out.println(GAME_COUNT_REQUEST_STATEMENT);
        return getInput();
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
