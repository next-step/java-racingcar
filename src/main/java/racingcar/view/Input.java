package racingcar.view;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);;
    }

    public Integer inputNumber() {
        return scanner.nextInt();
    }

}
