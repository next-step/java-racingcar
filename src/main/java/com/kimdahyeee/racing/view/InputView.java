package com.kimdahyeee.racing.view;

import java.util.Scanner;

public class InputView {
    public static String getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();

        return names;
    }

    public static int getTryCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
