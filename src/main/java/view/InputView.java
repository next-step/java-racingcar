package view;

import java.util.Scanner;

public class InputView {
    public static String getCarNames() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getPlayCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
