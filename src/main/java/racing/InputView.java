package racing;

import java.util.Scanner;

public class InputView {
    public static final String QUERY_NUMBER_OF_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String QUERY_NUMBER_OF_TRIALS_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static String[] queryCarNames() {
        System.out.println(QUERY_NUMBER_OF_CARS_MESSAGE);
        String input = scanner.nextLine();
        return input.split(",");
    }

    public static int queryNumberOfTrials() {
        System.out.println(QUERY_NUMBER_OF_TRIALS_MESSAGE);
        return scanner.nextInt();
    }
}
