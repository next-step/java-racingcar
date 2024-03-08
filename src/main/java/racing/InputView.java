package racing;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputtedNumber(String question) {
        System.out.println(question);
        while (true) {
            Optional<Integer> inputtedNumber = scanNextInt();
            if (inputtedNumber.isPresent()) {
                return inputtedNumber.get();
            }
        }
    }

    private Optional<Integer> scanNextInt() {

        try {
            int result = scanner.nextInt();
            scanner.nextLine();     // 버퍼 제거

            return Optional.of(result);
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
            scanner.nextLine();     // 버퍼 제거

            return Optional.empty();
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
