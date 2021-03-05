package carRacing.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputNumber() {
        return scanner.nextInt();
    }

}
