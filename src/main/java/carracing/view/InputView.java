package carracing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int inputCarNum() {
        System.out.println("경주에 참여할 자동차 수를 입력하세요.");
        return scanner.nextInt();
    }

    public int inputMoveNum() {
        System.out.println("자동차 이동 횟수를 입력하세요.");
        return scanner.nextInt();
    }
}
