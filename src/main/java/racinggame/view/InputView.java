package racinggame.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("숫자로 입력해주세요.");
        }
    }

    public int gameCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("숫자로 입력해주세요.");
        }
    }
}
