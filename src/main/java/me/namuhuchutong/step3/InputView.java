package me.namuhuchutong.step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int showPrompt(String text) {
        try {
            printThroughStandardOut(text);
            return inputFromStandardIn();
        } catch (InputMismatchException e ) {
            throw new IllegalArgumentException("숫자 이외에는 입력할 수 없습니다.");
        }
    }

    private void printThroughStandardOut(String text) {
        System.out.println(text);
    }

    private int inputFromStandardIn() {
        return scanner.nextInt();
    }
}
