package com.nextlevel.kky.racing.ui;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputNumber(String msg) {
        System.out.println(msg);

        return scanner.nextInt();
    }

    public static String[] inputString(String msg) {
        System.out.println(msg);

        return scanner.next().split(",");
    }
}
