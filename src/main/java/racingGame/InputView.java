package racingGame;

import java.util.Scanner;

public class InputView {
    public InputParameters askInput(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대인가요?");
        String carNum = scanner.next();
        System.out.println("시도할 회수는 몇 회인가요?");
        String tryNum = scanner.next();

        return new InputParameters(carNum,tryNum);
    }
}
