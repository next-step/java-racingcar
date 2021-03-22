package step03;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputRacingCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        ValidateUtils.inputIsZero(carCount);
        return carCount;
    }

    public static int inputRacingTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();
        ValidateUtils.inputIsZero(tryCount);
        return tryCount;
    }

    public static String inputRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.next();
        ValidateUtils.inputStringSplitTextSize(carNames);
        return carNames;
    }

}
