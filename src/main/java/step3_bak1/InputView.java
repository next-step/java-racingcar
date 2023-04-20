package step3_bak1;

import java.util.Scanner;

public class InputView {

    public static int input(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextInt();
    }
}
