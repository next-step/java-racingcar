package racingcar.step4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String InputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return sc.nextLine();
    }

    public static int InputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return sc.nextInt();

    }
}
