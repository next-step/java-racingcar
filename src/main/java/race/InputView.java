package race;

import java.util.Scanner;

public class InputView {

    private static final String messageCarCount = "자동차 대수는 몇 대 인가요?";

    private static final String messageGameCount = "시도할 회수는 몇 회 인가요?";

    private static int askInput() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    protected static int carCountInputOutput() {
        System.out.println(messageCarCount);
        return askInput();
    }

    protected static int gameCountInputOutput() {
        System.out.println(messageGameCount);
        return askInput();
    }
}
