package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return getScannerInput();
    }

    public static int getTotalGameCont() {
        System.out.println("시도할 회수는 몇회인가요?");
        return getScannerInput();
    }

    private static int getScannerInput() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
