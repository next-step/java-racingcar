package camp.nextstep.edu.racingcar.view;

import java.util.Scanner;

public final class RacingInputView {

    private static final Scanner sc = new Scanner(System.in);

    private RacingInputView() {
        throw new AssertionError("Cannot create a instance");
    }

    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public static int readRoundAmount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }
}
