package io;

import java.util.Scanner;

public class ConsoleScanner {
    private final static Scanner SCANNER = new Scanner(System.in);
    public static InputView input() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = SCANNER.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요");
        int tryCount = SCANNER.nextInt();

        return new InputView(carCount, tryCount);
    }
    private ConsoleScanner() {
    }
}
