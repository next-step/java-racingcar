package racingcar.external;

import java.util.Scanner;

public class InputChannel implements Input {
    Scanner scanner;

    public InputChannel() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int input(String s) {
        System.out.println(s);
        return scanner.nextInt();
    }
}
