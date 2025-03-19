package racingcar.ui;

import java.util.Scanner;

public class RacingCarInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static RacingCarInput view() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = SCANNER.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = SCANNER.nextInt();

        return new RacingCarInput(carCount, tryCount);
    }
}
