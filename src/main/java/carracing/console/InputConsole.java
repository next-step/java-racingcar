package carracing.console;

import java.util.Scanner;

/**
 * 자동차 경주를 위한 정보를 입력받는 콘솔
 */
public class InputConsole {
    private static final String NUMBER_OF_CARS_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_TRIALS_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private InputConsole() {
    }

    public static int readNumberOfTrials() {
        System.out.println(NUMBER_OF_TRIALS_INPUT_MESSAGE);
        return Integer.parseInt(readString());
    }

    public static int readNumberOfCars() {
        System.out.println(NUMBER_OF_CARS_INPUT_MESSAGE);
        return Integer.parseInt(readString());
    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
