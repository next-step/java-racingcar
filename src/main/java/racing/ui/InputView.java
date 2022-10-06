package racing.ui;

import java.util.Scanner;

public class InputView {

    public static Form createForm() {
        String carNames = inputCarNames();
        int playCounts = inputPlayCounts();
        return new Form(carNames, playCounts);
    }

    private static int inputPlayCounts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner playScanner = new Scanner(System.in);
        return playScanner.nextInt();
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner carScanner = new Scanner(System.in);
        return carScanner.nextLine();
    }
}
