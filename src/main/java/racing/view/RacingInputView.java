package racing.view;

import racing.model.RacingConstant;

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
            int countOfTry = scanner.nextInt();
            return validateCount(countOfTry);
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(RacingConstant.WRONG_INPUT_VALUE, e);
        }
    }

    private int validateCount(int countOfTry) {
        if (countOfTry == RacingConstant.ZERO_NUMBER) {
            throw new IllegalArgumentException(RacingConstant.WRONG_INPUT_VALUE);
        }
        return 0;
    }

    public void close() {
        scanner.close();
    }
}
