package racingcar.external;

import java.util.Scanner;

public class InputChannel implements Input {
    Scanner scanner;

    public InputChannel() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int inputNumber(String s) {
        System.out.println(s);
        return scanner.nextInt();
    }

    @Override
    public String inputString(String s) {
        System.out.println(s);
        return scanner.next();
    }
}
