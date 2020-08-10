package view;

import core.Value;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static void getInputValue(){
        System.out.println(Value.getCarGuide());
        Value.setCarCount(checkInputValue(scanner.nextInt()));

        System.out.println(Value.getRoundGuide());
        Value.setRound(checkInputValue(scanner.nextInt()));
    }

    static int checkInputValue(int inputValue) {
        if(inputValue < 0 || inputValue != (int)inputValue) {
            throw new IllegalArgumentException();
        }
        return inputValue;
    }
}
