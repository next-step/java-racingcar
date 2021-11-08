package edu.nextstep.camp;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int inputPositiveNumber(String message) {
        System.out.println(message);
        int number = 0;
        while (number <= 0) {
            number = getAndValidate();
        }

        return number;
    }

    private int getAndValidate() {
        final int number = scanner.nextInt();
        if (number <= 0) {
            System.out.println("1 이상의 정수값을 입력해주세요");
        }

        return number;
    }
}
