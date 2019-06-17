package carRacing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public int inputFromUser() {

        int number;
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("잘못된 입력 입니다. 정확한 숫자만 입력해주세요.");
        }
        return number;
    }
}
