package racingcar.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {


    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String CAR_COUNT_PROMPT = "자동차 대수는 몇 대 인가요?";
    public static final String INVALID_NUMBER_MESSAGE = "숫자가 아닌 값이 포함되어 있습니다.";
    public static final String ATTEMPT_COUNT_PROMPT = "시도할 회수는 몇 회 인가요?";

    public static int readCarCount() {
        return readNumber(CAR_COUNT_PROMPT);
    }

    public static int readAttemptCount() {
        return readNumber(ATTEMPT_COUNT_PROMPT);

    }

    private static int readNumber(String prompt) {
        System.out.println(prompt);
        String inputCarCount = SCANNER.nextLine();
        if (!NUMBER_PATTERN.matcher(inputCarCount).matches()) {
            throw new RuntimeException(INVALID_NUMBER_MESSAGE);
        }
        return Integer.parseInt(inputCarCount);
    }



}
