package main.java.racingCar.view;

import java.util.Scanner;

public class InputViewer {
    private static final Scanner SCANNER = new Scanner(System.in);

    public InputViewer(){
    }
    public int carInputViewer(){
        int number = SCANNER.nextInt();
        return number;
    }
    public int tryInputViewer(){
        int number = SCANNER.nextInt();
        return number;
    }
}
