package edu.nextstep.racing;

import java.util.Scanner;

public class InputView {
    public int inputer() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        return number;
    }
}
