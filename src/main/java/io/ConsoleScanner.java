package io;

import java.util.Scanner;

public class ConsoleScanner {
    private final static Scanner SCANNER = new Scanner(System.in);
    public static InputView input() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String owners = SCANNER.next();
        System.out.println("시도할 회수는 몇 회 인가요");
        int tryCount = SCANNER.nextInt();

        return new InputView(owners, tryCount);
    }
    private ConsoleScanner() {
    }
}
