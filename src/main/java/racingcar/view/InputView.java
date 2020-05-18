package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static String TEXT_QUESTION_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static String TEXT_QUESTION_RACING_TIME = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int inputCarCountJoinRace() {
        return getInputConsole(TEXT_QUESTION_CAR_COUNT);
    }

    public static int inputRaceTime() {
        return getInputConsole(TEXT_QUESTION_RACING_TIME);
    }

    private static int getInputConsole(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}
