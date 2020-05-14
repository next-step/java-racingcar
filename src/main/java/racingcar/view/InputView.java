package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static int inputNumberOfPhase() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
