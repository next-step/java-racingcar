package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String STAGE_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static int carInput() {
        System.out.println(CAR_INPUT_MESSAGE);
        return scanner.nextInt();
    }

    public static int stageInput() {
        System.out.println(STAGE_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
