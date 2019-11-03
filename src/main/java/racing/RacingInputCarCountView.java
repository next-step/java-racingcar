package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingInputCarCountView {

    private static final String CHECK_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String RETRY_INPUT_VALUE = "잘못된 입력 값입니다. 다시 입력하세요.";

    public int carCount;

    public RacingInputCarCountView() {
        Scanner scanner = new Scanner(System.in);
        carCount = inputCarCount(scanner);
    }

    private int inputCarCount(Scanner scanner) {
        System.out.println(CHECK_CAR_COUNT);
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
