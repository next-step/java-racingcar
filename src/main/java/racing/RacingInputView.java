package racing;

import java.util.Scanner;

public class RacingInputView {

    private static final String CHECK_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String CHECK_RUN_TIME = "시도할 회수는 몇 회 인가요?";

    public int carCount;
    public int time;

    public RacingInputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CHECK_CAR_COUNT);
        carCount = scanner.nextInt();
        System.out.println(CHECK_RUN_TIME);
        time = scanner.nextInt();
    }
}
