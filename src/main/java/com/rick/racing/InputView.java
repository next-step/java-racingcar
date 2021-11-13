package com.rick.racing;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    private int numberOfCars = 0;
    private int numberOfTries = 0;

    public void showInputUI() {
        showMessageAndGetNumberOfCarsFromUser();
        showMessageAndGetNumberOfTriesFromUser();
    }

    private void showMessageAndGetNumberOfCarsFromUser() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        numberOfCars = getNumber();
    }

    private void showMessageAndGetNumberOfTriesFromUser() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        numberOfTries = getNumber();
    }

    private int getNumber() {
        String value = scanner.nextLine();
        return Integer.parseInt(value);
    }


    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }
}
