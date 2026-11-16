package racingcar.view;

import java.util.Scanner;
import java.util.regex.Pattern;

import static racingcar.view.InputValidator.validate;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_COUNT_PROMPT = "자동차 대수는 몇 대 인가요?";
    private static final String ATTEMPT_COUNT_PROMPT = "시도할 회수는 몇 회 인가요?";

    public static int readCarCount() {
        System.out.println((CAR_COUNT_PROMPT));
        String carCount = readLine();
        validate(carCount);

        return Integer.parseInt(carCount);
    }

    public static int readAttemptCount() {
        System.out.println((ATTEMPT_COUNT_PROMPT));
        String attemptCount = readLine();
        validate(attemptCount);

        return Integer.parseInt(attemptCount);
    }


    private static String readLine() {
        String carCount = SCANNER.nextLine();
        return carCount;
    }



}
