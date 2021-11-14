package com.kkambi.racing.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?";
    private static final String QUESTION_NUMBER_OF_TRIES = "시도할 회수는 몇 회인가요?";

    public int getNumberOfCars() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_NUMBER_OF_CARS);
        return scanner.nextInt();
    }

    public int getNumberOfTries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_NUMBER_OF_TRIES);
        return scanner.nextInt();
    }
}
