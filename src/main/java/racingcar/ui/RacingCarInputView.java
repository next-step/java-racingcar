package racingcar.ui;

import java.util.Scanner;

public class RacingCarInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static RacingCarInput view() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameCsv = SCANNER.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = SCANNER.nextInt();

        return new RacingCarInput(carNameCsv, tryCount);
    }
}
