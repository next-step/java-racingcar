package racingcar;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    private int inputScannerInt() {
        return scanner.nextInt();
    }

    public String[] insertRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 (쉼표,)를 기준으로 구분).");
        String carNamesWithComma = inputScannerString();
        return splitCarNames(carNamesWithComma);
    }

    private String inputScannerString() {
        return scanner.nextLine();
    }

    private String[] splitCarNames(String carNamesWithComma) {
        return carNamesWithComma.split(",");
    }

    public int insertTotalRacingRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputScannerInt();
    }

}
