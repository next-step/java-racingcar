package racing;

import common.CommonConstant;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingInputTimeView {

    private static final String CHECK_RUN_TIME = "시도할 회수는 몇회인가요?";

    public int time;

    public RacingInputTimeView(Scanner scanner) {
        time = inputTime(scanner);
    }

    private int inputTime(Scanner scanner) {
        System.out.println(CHECK_RUN_TIME);
        return validateInputValue(scanner);
    }

    private int validateInputValue(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.close();
            throw new InputMismatchException(CommonConstant.WRONG_INPUT_VALUE);
        }
    }
}
