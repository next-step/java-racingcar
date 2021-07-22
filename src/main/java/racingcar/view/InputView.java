package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_SPLITTER = ",";

    private static final String INPUT_CARS_NAMES_STATEMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TOTAL_ROUND_STATEMENT = "시도할 회수는 몇 회 인가요?";

    private InputView() {}

    public static int inputRound() {
        printStatement(INPUT_TOTAL_ROUND_STATEMENT);
        return getInt();
    }

    public static String[] inputCarNames() {
        printStatement(INPUT_CARS_NAMES_STATEMENT);
        return Arrays.stream(SCANNER.nextLine()
                .split(NAME_SPLITTER))
                .map(String::trim)
                .toArray(String[]::new);
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static int getInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
