package com.nextstep.javaRacing.racing.view;

import java.util.Scanner;

public class InputView {

    private static final String CARS_INPUT_MESSAGE = "몇 대의 차량이 있나요? : ";
    private static final String TURNS_INPUT_MESSAGE = "몇 대의 차량이 있나요? : ";

    public static int scanCars(){
        System.out.println(CARS_INPUT_MESSAGE);
        return scanNumber();
    }

    public static int scanTurns(){
        System.out.println(TURNS_INPUT_MESSAGE);
        return scanNumber();
    }

    private static int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
