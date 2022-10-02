package racing;

import java.util.Scanner;

public class InputView {
    public static final String QUERY_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String QUERY_NUMBER_OF_TRIALS_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int queryNumberOfCars() {
        System.out.println(QUERY_NUMBER_OF_CARS_MESSAGE);
        return scanner.nextInt();
    }

    public static int queryNumberOfTrials() {
        System.out.println(QUERY_NUMBER_OF_TRIALS_MESSAGE);
        return scanner.nextInt();
    }
}
