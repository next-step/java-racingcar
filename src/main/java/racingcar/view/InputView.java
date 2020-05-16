package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String NAME_ARRAY_OF_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String LOOP_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputNameOfCars() {
        return inputString(NAME_ARRAY_OF_CARS_MESSAGE);
    }

    public static int inputLoopCount() {
        return input(LOOP_COUNT_MESSAGE);
    }

    private static String inputString(final String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

    private static int input(String message) {
        System.out.println(message);
        return SCANNER.nextInt();
    }
}
