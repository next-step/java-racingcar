package racingcar;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int insertRacingCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return inputScannerInt();
    }

    public int insertTotalRacingRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputScannerInt();
    }

    private int inputScannerInt() {
        return scanner.nextInt();
    }
}
