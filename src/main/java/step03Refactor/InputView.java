package step03Refactor;

import java.util.Scanner;

import static step03Refactor.Config.*;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputRacingTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        int tryCount = scanner.nextInt();
        ValidateUtil.inputIsZero(tryCount);
        return tryCount;
    }

    public static String inputRacingCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        String carNames = scanner.next();
        ValidateUtil.inputStringSplitTextSize(carNames);
        return carNames;
    }
}
