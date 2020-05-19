package step3.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String RACING_CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String MOVE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";

    private static final String CAR_NAME_DELEMETER = ",";

    private InputView() {
    }

    public static String[] getRacingCarNames() {
        System.out.println(RACING_CAR_NAME_QUESTION);
        String inputCarName = scanner.nextLine();
        return Arrays.stream(inputCarName.split(CAR_NAME_DELEMETER))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public static int getGameRound() {
        System.out.println(MOVE_COUNT_QUESTION);
        return scanner.nextInt();
    }
}
