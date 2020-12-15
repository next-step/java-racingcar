package step3.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public int input() {
        return scanner.nextInt();
    }
}
