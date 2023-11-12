package view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int getInputIntValue(String text) {
        System.out.println(text);
        return scanner.nextInt();
    }

    public String getInputStringValue(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }
}
