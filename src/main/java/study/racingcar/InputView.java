package study.racingcar;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int getCarNumber() {
        return scanner.nextInt();
    }

    public int getTryCount() {
        return scanner.nextInt();
    }
}
