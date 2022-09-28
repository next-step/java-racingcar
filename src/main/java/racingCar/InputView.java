package racingCar;

import java.util.Scanner;

public class InputView {
    public static final String Q_CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
    public static final String Q_TRY_TIMES = "시도할 회수는 몇 회 인가요?";
    public static final String Q_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static Scanner scanner = new Scanner(System.in);

    public static int printQuestionInputInt(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }

    public static String printQuestionInputString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
