package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingCarInput {

    private static final String INPUT_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INPUT_RETRY_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String COMMA = ",";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    private static Scanner scanner = new Scanner(System.in);

    private RacingCarInput() {
    }

    public static List<String> getCarName() {
        String input = "";
        RacingCarView.printMessage(INPUT_CARNAME_MESSAGE);
        try {
            input = scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getCarName();
        }
        return Arrays.asList(input.split(COMMA));
    }

    public static int getRaceCount() {
        String input = "";
        RacingCarView.printMessage(INPUT_RETRY_MESSAGE);
        try {
            input = scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getRaceCount();
        }
        return Integer.parseInt(input);
    }
}
