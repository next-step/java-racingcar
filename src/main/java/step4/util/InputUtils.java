package step4.util;

import java.util.Scanner;

public class InputUtils {
    private static final String INPUT_NAME_OF_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_NUMBER_OF_MOVEMENT = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner = new Scanner(System.in);

    private InputUtils() {
        throw new AssertionError("생성자 호출 금지");
    }


    public static int inputMoveView() {
        return InputNumber(INPUT_NUMBER_OF_MOVEMENT);
    }

    private static int InputNumber(String inputQuestion) {
        System.out.println(inputQuestion);
        return scanner.nextInt();
    }

    public static String[] inputCarNameView() {
        System.out.println(INPUT_NAME_OF_CAR);
        Scanner scanner = new Scanner(System.in);
        return scanner.next().split(",");
    }

}
