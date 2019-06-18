/*
 * ClassName : InputRacingInfo.java
 *
<<<<<<< HEAD
 * Version : 1.1
=======
 * Version : 1.0
>>>>>>> feat(Input) : 자동차경주 Input 클래스 생성
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
    private Scanner in = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carName = "";

        try {
            carName = in.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("[Error] 올바른 값을 입력해주세요.");
            e.printStackTrace();
        }

        return carName;
    }

    public int inputTryOfNumber() {
        System.out.println("시도할 회수는 몇회인가요?");

        int num = 0;

        try {
            num = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[Error] 올바른 값을 입력해주세요.");
            e.printStackTrace();
        }

        if (num <= 0) {
            throw new IllegalArgumentException("자동차 대수는 0 이하일 수 없습니다.");
        }

        return num;
    }

    public String[] getCarTotalNames() {
        return this.carTotalNames;
    }

    public int getTryOfNumbers() {
        return this.tryOfNumbers;
    }
}
