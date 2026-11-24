package racingcar.view;

import java.util.Scanner;

import static racingcar.view.InputValidator.validateNumber;

public class InputView {

    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ATTEMPT_COUNT_PROMPT = "시도할 회수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readCarNames() {
        System.out.println((CAR_NAMES_PROMPT));
        return readLine();
    }

    public static int readAttemptCount() {
        System.out.println((ATTEMPT_COUNT_PROMPT));
        String attemptCount = readLine();
        validateNumber(attemptCount);

        return Integer.parseInt(attemptCount);
    }


    private static String readLine() {
        return SCANNER.nextLine();
    }



}
