package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingInputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String CHECK_RUN_TIME = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public RacingInputView() {
        scanner = new Scanner(System.in);
    }

    public String inputNameOfCar() {
        System.out.println(INPUT_CAR_NAMES);
        return scanner.nextLine();
    }

    public int inputCountOfTry() {
        System.out.println(CHECK_RUN_TIME);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(RacingConstant.WRONG_INPUT_VALUE, e);
        }
    }

    public void close() {
        scanner.close();
    }
}
