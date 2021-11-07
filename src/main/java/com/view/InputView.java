package com.view;

import com.NumberSet;

import java.util.Scanner;

public class InputView {
    public NumberSet input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = scanner.nextInt();
        System.out.println();

        return new NumberSet(carCount, attemptCount);
    }
}
