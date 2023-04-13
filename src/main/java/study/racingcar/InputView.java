package study.racingcar;

import java.util.Scanner;

public class InputView {
    /**
     * 입력을 담당한다.
     */
    private final Scanner scanner = new Scanner(System.in);

    public int getCarNumber() {
        return scanner.nextInt();
    }

    public int getTryCount() {
        return scanner.nextInt();
    }
}