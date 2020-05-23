package main.java.racingCar.view;

import java.util.Scanner;

public class InputViewer {
    private static final Scanner SCANNER = new Scanner(System.in);

    public InputViewer(){
    }
    public int carInputViewer(){
        String value = SCANNER.nextLine();
        int number = SCANNER.nextInt();
        return 0;
    }
    public int tryInputViewer(){
        return 0;
    }
}
