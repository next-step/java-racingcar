package racingcar.view;

import java.io.PrintStream;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream out = System.out;
    private static final String CAR_NUM_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_NUM_QUESTION = "시도할 회수는 몇 회 인가요?";

    public static int getCarNum() {
        out.println(CAR_NUM_QUESTION);
        return scanner.nextInt();
    }

    public static int getGameRoundNum() {
        out.println(ROUND_NUM_QUESTION);
        return scanner.nextInt();
    }
}
