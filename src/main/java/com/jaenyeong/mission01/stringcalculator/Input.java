package com.jaenyeong.mission01.stringcalculator;

import java.util.Scanner;

public class Input {
    private final Scanner scan;

    public Input() {
        this.scan = new Scanner(System.in);
    }

    public String inputString() {
        return scan.nextLine();
    }
}
