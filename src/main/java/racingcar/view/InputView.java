package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_CAR_MOVE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private InputView() throws InstantiationException {
        throw new InstantiationException();
    }

    public static int inputCarMoveCount() {
        System.out.println(INPUT_CAR_MOVE_COUNT_MESSAGE);

        return inputInt();
    }

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);

        return SCANNER.nextLine();
    }

    private static int inputInt() {
        return SCANNER.nextInt();
    }
}
