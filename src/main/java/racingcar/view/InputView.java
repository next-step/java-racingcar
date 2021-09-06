package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String QUESTION_OF_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String QUESTION_OF_ATTEMPT = "시도할 횟수는 몇 회 인가요?";

    public static String inputCarName() {
        System.out.println(QUESTION_OF_CAR_NAME);
        return SCANNER.nextLine();
    }

    public static int inputAttempt() {
        return answer(QUESTION_OF_ATTEMPT);
    }

    public static int answer(String question) {
        System.out.println(question);
        int answer = SCANNER.nextInt();

        checkTheAttempt(answer);

        return answer;
    }

    private static void checkTheAttempt(int attemptNumber) {
        if (attemptNumber < 1) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력하세요.");
        }
    }

}
