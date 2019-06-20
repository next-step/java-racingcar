package com.java.jaeheon.step2.view;

import java.util.Scanner;

public class InputView {
    public static int inputViewNumberOfCars() {
        return inputViewScanner("자동차 대수는 몇 대 인가요?");
    }

    public static int inputViewNumberOfAttempts() {
        return inputViewScanner("시도할 회수는 몇 회 인가요?");
    }

    private static int inputViewScanner(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
