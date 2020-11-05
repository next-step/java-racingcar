package step3;

import static step3.RacingCarApplication.SCANNER;

public class InputView {
    static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextInt();
    }

    static int inputMoveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }
}
