package study.step3.ui;

import java.util.Scanner;

import study.step3.utils.Printer;

public class InputView {
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputCount(String message) {
        Printer.println(message);
        return Integer.parseInt(scanner.nextLine());
    }
}

