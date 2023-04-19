package study.racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getTryCount() {
        return getNumber();
    }

    public static String getCarNames() {
        return scanner.next();
    }

    private static int getNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}