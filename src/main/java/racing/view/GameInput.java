package racing.view;

import java.util.Scanner;

public class GameInput {

    private static final String ASK_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_ROUND_COUNT = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public int carCount() {
        System.out.println(ASK_CAR_COUNT);
        return scanner.nextInt();
    }

    public int roundCount() {
        System.out.println(ASK_ROUND_COUNT);
        return scanner.nextInt();
    }
}
