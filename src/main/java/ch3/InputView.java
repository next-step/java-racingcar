package ch3;

import java.util.Scanner;

public class InputView {

    public int getInputIntValue(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextInt();
    }

    public String getInputStringValue(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }
}
