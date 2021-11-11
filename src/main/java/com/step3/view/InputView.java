package com.step3.view;

import com.step3.model.InputNumber;

import java.util.Scanner;

public class InputView {
    public InputNumber input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carsName = scanner.nextLine().split(",");

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = scanner.nextInt();
        System.out.println();

        return new InputNumber(carsName, attemptCount);
    }
}
