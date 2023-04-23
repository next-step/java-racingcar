package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);

    public String inputString() {
        return scanner.nextLine();
    }

    public int inputInt() {
        int playCount;
        try {
            playCount = scanner.nextInt();
        } catch (InputMismatchException ime) {
            throw new InputMismatchException("숫자를 입력하세요.");
        }
        return playCount;
    }
}
