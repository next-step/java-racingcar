package racingcar.view;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream out = System.out;
    private static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_NUM_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String SPLIT_UNIT = ",";
    private static final int MAX_NAME_LENGTH = 5;

    private InputView() {
    }

    public static List<String> getCarNames() {
        out.println(CAR_NAMES_QUESTION);
        String input = scanner.nextLine();
        List<String> names = splitWithRest(input);

        checkNamesLength(names);

        return names;
    }

    private static void checkNamesLength(List<String> names) {
        names.forEach(InputView::checkNameLength);
    }

    private static void checkNameLength(String name) {
        if (isNameOverMaxLength(name))
            throw new InputMismatchException("MAX NAME LENGTH: " + MAX_NAME_LENGTH + ", NAME: " + name);
    }

    private static boolean isNameOverMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private static List<String> splitWithRest(String input) {
        return Arrays.asList(input.split(SPLIT_UNIT));
    }

    public static int getGameRoundNum() {
        out.println(ROUND_NUM_QUESTION);
        return scanner.nextInt();
    }
}
