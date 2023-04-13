package racingcar;

import static java.util.Optional.ofNullable;
import static racingcar.InputView.SplitString.stringList;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputView {

    public static class SplitString {

        public static final String DELIMITER = ",";

        protected static List<String> stringList(String input) {
            return Arrays.asList(splitStrings(input));
        }

        private static String[] splitStrings(String input) {
            return input.split(DELIMITER);
        }

    }

    public static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    public static final String RACE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    public static final InputStream DEFAULT_INPUT_STREAM = System.in;
    public static final String CARS_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static Scanner scanner;

    public static List<String> askCarNames() {
        return askCarNames(DEFAULT_INPUT_STREAM);
    }

    public static int askRaceCount() {
        return askRaceCount(DEFAULT_INPUT_STREAM);
    }

    public static int askCarCount() {
        return askCarCount(DEFAULT_INPUT_STREAM);
    }

    public static List<String> askCarNames(InputStream inputStream) {
        askQuestion(CARS_NAME_QUESTION);
        return stringList(scanInput(ofNullable(inputStream)));
    }

    public static int askRaceCount(InputStream inputStream) {
        askQuestion(RACE_COUNT_QUESTION);
        return toInt(scanInput(ofNullable(inputStream)));
    }

    public static int askCarCount(InputStream inputStream) {
        askQuestion(CAR_COUNT_QUESTION);
        return toInt(scanInput(ofNullable(inputStream)));
    }

    private static void askQuestion(String question) {
        System.out.println(question);
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }

    private static String scanInput(Optional<InputStream> inputStream) {
        if (isEmptyScanner()) {
            scanner = new Scanner(inputStream.orElse(DEFAULT_INPUT_STREAM));
        }
        return scanner.next();
    }

    private static boolean isEmptyScanner() {
        return scanner == null;
    }

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

}
