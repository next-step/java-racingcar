package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String inputCarCount() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public static int inputTrialCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
