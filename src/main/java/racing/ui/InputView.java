package racing.ui;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumber(String s) {
        System.out.println(s);
        return scanner.nextInt();
    }
}
