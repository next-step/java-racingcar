package study.racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    /**
     * 입력을 담당한다. (입력에 대한 검증 책임 있음)
     */
    private static final Scanner scanner = new Scanner(System.in);

    public static int getCarNumber() {
        return getNumber();
    }

    public static int getTryCount() {
        return getNumber();
    }

    private static int getNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}