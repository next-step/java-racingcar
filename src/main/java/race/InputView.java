package race;

import java.util.Scanner;

public class InputView {
    public static final String CAR_NAMES_REQUEST_STATEMENT = "경주할 자동차 이름을 입력하세요(각 이름은 5글자 이하, 자동차는 최소 2대 이상이며, 쉼표(,)를 기준으로 구분)";
    public static final String GAME_COUNT_REQUEST_STATEMENT = "시도할 회수는 몇 회 인가요? (1 이상의 숫자 입력)";

    public static String inputCarName() {
        System.out.println(CAR_NAMES_REQUEST_STATEMENT);
        return getInputString();
    }

    public static int inputGameCount() {
        System.out.println(GAME_COUNT_REQUEST_STATEMENT);
        return getInputInteger();
    }

    private static int getInputInteger() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
