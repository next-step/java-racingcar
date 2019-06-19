package com.iksoo.racer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputRacingValues {
    int inputCars() {
        Scanner scanner = new Scanner(System.in);
        int carNumbers = 0;

        System.out.println("자동차 대수는 몇 대 인가요?");

        try {
            carNumbers = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[Error] 숫자를 입력해주세요.");
            e.printStackTrace();
        }

        if (carNumbers <= 0) {
            throw new IllegalArgumentException("자동차 대수는 0 이하일 수 없습니다.");
        }

        return carNumbers;
    }

    int inputTrys() {
        Scanner scanner = new Scanner(System.in);
        int tryNumbers = 0;

        System.out.println("시도할 회수는 몇 회 인가요?");

        try {
            tryNumbers = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[Error] 숫자를 입력해주세요.");
            e.printStackTrace();
        }

        if (tryNumbers <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이하일 수 없습니다.");
        }

        return tryNumbers;
    }
}
