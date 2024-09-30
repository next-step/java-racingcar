package race;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_NUMBER_OF_MOVEMENT = "시도할 회수는 몇 회 인가요?";


    private static Scanner scanner = new Scanner(System.in);

    public static void inputCarView() {
        System.out.println(INPUT_NUMBER_OF_CAR);
    }

    public static void inputMoveView() {
        System.out.println(INPUT_NUMBER_OF_MOVEMENT);
    }

    public static int inputCarNumber() {
        return scanner.nextInt();
    }

    public static int inputMovementNumber() {
        return scanner.nextInt();
    }
}
