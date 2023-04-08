package racingcar;

import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

public class InputView {

    public static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    public static final String RACE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    public static final InputStream DEFAULT_INPUT_STREAM = System.in;

    private static Scanner scanner;

    public static int askRaceCount(InputStream inputStream) {
        askQuestion(RACE_COUNT_QUESTION);
        return toInt(scanInput(Optional.ofNullable(inputStream)));
    }

    public static int askCarCount(InputStream inputStream) {
        askQuestion(CAR_COUNT_QUESTION);
        return toInt(scanInput(Optional.ofNullable(inputStream)));
    }

    private static void askQuestion(String question) {
        System.out.println(question);
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }

    private static String scanInput(Optional<InputStream> inputStream) {
        if (isScannerEmpty()) {
            scanner = new Scanner(inputStream.orElse(DEFAULT_INPUT_STREAM));
        }
        return scanner.next();
    }

    private static boolean isScannerEmpty() {
        return scanner == null;
    }

}
