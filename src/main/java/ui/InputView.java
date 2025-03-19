package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer queryIntegerInputWithPrompt(String question) {
        System.out.println(question);
        Integer number = null;

        while (number == null) {
            number = scanInteger();
        }

        return number;
    }

    private Integer scanInteger() {
        Integer number = null;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("유효하지 않은 입력입니다. 정수를 입력하세요.");
            scanner.nextLine(); // 잘못된 입력을 버퍼에서 제거
        }
        return number;
    }
}
