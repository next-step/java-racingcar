package laststep.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public static List<String> participants() {
        String input = sc.nextLine();
        validateSeparator(input);

        return Arrays.stream(input.split(SEPARATOR)).collect(Collectors.toList());
    }

    public static int howManyPlay() {
        int playTimes = changeNumber(sc.nextLine());
        checkPlayTimes(playTimes);
        return playTimes;
    }

    private static void checkPlayTimes(int playTimes) {
        if (playTimes < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1이상 입력해주세요");
        }
    }

    private static int changeNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    private static void validateSeparator(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("',' 를 포함해서 입력해 주세요");
        }
    }

    private InputView() {}
}
