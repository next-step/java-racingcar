package racing.ui;

import java.util.Scanner;

public class InputView {

    public static int input(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        return scanner.nextInt();
    }

}
