package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NUMBER_OF_CARS_STATEMENT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TOTAL_ROUND_STATEMENT = "시도할 회수는 몇 회 인가요?";

    private InputView() {}

    public static int inputRound() {
        printStatement(INPUT_TOTAL_ROUND_STATEMENT);
        return getInt();
    }

    public static int inputNumberOfCars() {
        printStatement(INPUT_NUMBER_OF_CARS_STATEMENT);
        return getInt();
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static int getInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
