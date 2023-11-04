package me.namuhuchutong.step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int showPrompt(String text) {
        printThroughStandardOut(text);
        return inputFromStandardIn();
    }

    private void printThroughStandardOut(String text) {
        System.out.println(text);
    }

    private int inputFromStandardIn() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
