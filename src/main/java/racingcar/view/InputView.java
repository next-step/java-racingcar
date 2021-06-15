package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_CYCLE_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String inputCarInfo() {
        System.out.println(INPUT_CAR_MESSAGE);
        return SCANNER.next();
    }

    public static int inputCycle() {
        System.out.println(INPUT_CYCLE_MESSAGE);
        return SCANNER.nextInt();
    }

}
