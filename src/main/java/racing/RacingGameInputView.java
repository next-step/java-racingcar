package racing;

import java.util.Scanner;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-28 00:09
 */
public class RacingGameInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_INPUT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_ATTEMPT_QUESTION = "시도할 회수는 몇 회 인가요?";

    public static int getNumberOfCars() {
        System.out.println(CAR_INPUT_QUESTION);
        return scanner.nextInt();
    }

    public static int getNumberOfAttempt() {
        System.out.println(GAME_ATTEMPT_QUESTION);
        return scanner.nextInt();
    }
}
