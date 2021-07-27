package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getInt(String message) {
        System.out.println(message);
        int returnNumber = 0;
        try {
            returnNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자 값을 입력해주세요.");
        }
        return returnNumber;
    }

}
