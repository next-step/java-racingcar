package com.kimdahyeee.racing.view;

import java.util.Scanner;

public class InputView {
    public static int getCarCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        return carCount;
    }

    public static int getTryCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
