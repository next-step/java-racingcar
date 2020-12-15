package step3.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int getCarCount() {
        return scanner.nextInt();
    }

    public int getRoundTime() {
        return scanner.nextInt();
    }
}
