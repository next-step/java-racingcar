package step3.util;

import java.util.Scanner;

public class InputUtils {
    private static final String INPUT_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_NUMBER_OF_MOVEMENT = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner = new Scanner(System.in);

    private InputUtils() {
        throw new AssertionError("생성자 호출 금지");
    }

    public static int inputCarView() {
        return InputNumber(INPUT_NUMBER_OF_CAR);
    }

    public static int inputMoveView() {
        return InputNumber(INPUT_NUMBER_OF_MOVEMENT);
    }

    private static int InputNumber(String inputQuestion) {
        System.out.println(inputQuestion);
        return scanner.nextInt();
    }

}
