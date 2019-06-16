package com.iksoo.racer;

import java.util.Scanner;

public class InputRacingValues {
    int inputCars()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumbers = scanner.nextInt();

        return carNumbers;
    }

    int inputTrys()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNumbers = scanner.nextInt();

        return tryNumbers;
    }
}
