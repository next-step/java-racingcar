/*
 * ClassName : InputRacingInfo.java
 *
 * Version : 1.0
 *
 * Create Date : 2019.06.17
 *
 * Creator : 신익수
 *
 */
package com.iksoo.step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputRacingInfo {
    private String carTotalNames;
    private int tryOfNumbers;
    Scanner in;

    InputRacingInfo() {
        in = new Scanner(System.in);

        try {
            this.carTotalNames = inputCarNames();
            this.tryOfNumbers = inputTryOfNumber();
        } catch (InputMismatchException e) {
            System.out.println("[Error] 올바른 값을 입력해주세요.");
            e.printStackTrace();
        }
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return in.nextLine();
    }

    public int inputTryOfNumber() {
        System.out.println("시도할 회수는 몇회인가요?");

        int num = in.nextInt();

        if (num <= 0) {
            throw new IllegalArgumentException("자동차 대수는 0 이하일 수 없습니다.");
        }

        return num;
    }

    public String getCarTotalNames() {
        return this.carTotalNames;
    }

    public int getTryOfNumbers() {
        return this.tryOfNumbers;
    }
}
