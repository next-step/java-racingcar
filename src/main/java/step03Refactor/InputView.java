package step03Refactor;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputRacingTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();
        ValidateUtil.inputIsZero(tryCount);
        return tryCount;
    }

    public static String inputRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.next();
        ValidateUtil.inputStringSplitTextSize(carNames);
        return carNames;
    }
}
