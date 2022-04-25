package step3.view;

import java.util.Scanner;
import step3.RacingGame;
import step3.exception.InputFailException;

public class InputView {

    public static RacingGame show() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("자동차 대수는 몇 대 인가요?");
            int carNUmber = scanner.nextInt();
            System.out.println("시도할 회수는 몇 회 인가요?");
            int moveNumber = scanner.nextInt();
            return RacingGame.of(carNUmber, moveNumber);
        } catch (RuntimeException e) {
            throw new InputFailException("입력을 받는데 실패했습니다.", e);
        }
    }
}
