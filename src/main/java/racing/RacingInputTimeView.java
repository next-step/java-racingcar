package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingInputTimeView {

    private static final String CHECK_RUN_TIME = "레이싱 진행 횟수는 몇 회 인가요?";
    private static final String RETRY_INPUT_VALUE = "잘못된 입력 값입니다. 다시 입력하세요.";

    public int time;

    public RacingInputTimeView() {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println(RETRY_INPUT_VALUE);
            return validateInputValue(new Scanner(System.in));
        }
    }
}
