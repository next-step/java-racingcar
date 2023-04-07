package racingcar;

import java.util.Scanner;

public class InputView {

    public static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    public static final String RACE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";

    static final Scanner scanner = new Scanner(System.in);

    public static int askRaceCount() {
        askQuestion(RACE_COUNT_QUESTION);
        return toInt(scanInput());
    }

    public static int askCarCount() {
        askQuestion(CAR_COUNT_QUESTION);
        return toInt(scanInput());
    }

    private static void askQuestion(String question) {
        System.out.println(question);
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }

    private static String scanInput() {
        return scanner.next();
    }

}
