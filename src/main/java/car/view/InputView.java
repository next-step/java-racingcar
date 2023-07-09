package car.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String enterCarName() {
        OutputView.printCarNameText();
        String inputCarName = scanner.nextLine();
        if (inputCarName.isBlank()) {
            throw new IllegalArgumentException("값을 입력해 주세요");
        }
        return inputCarName;
    }

    public static int enterCount() {
        OutputView.printCountText();
        int inputCount;
        try {
            inputCount = scanner.nextInt();
        } catch (InputMismatchException ignore) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        } finally {
            scanner.close();
        }
        return inputCount;
    }
}
