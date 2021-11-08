package edu.nextstep.camp;

import java.util.Scanner;

public class InputView {
    private static final int VALIDATE_NUMBER = 0;

    private final Scanner scanner = new Scanner(System.in);

    public int inputPositiveNumber(String message) {
        System.out.println(message);
        int number;
        do {
            number = getAndValidate();
        } while (number <= VALIDATE_NUMBER);

        return number;
    }

    private int getAndValidate() {
        final int number = scanner.nextInt();
        if (number <= VALIDATE_NUMBER) {
            System.out.println("1 이상의 정수값을 입력해주세요");
        }

        return number;
    }
}
