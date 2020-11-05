package racingcar.external;

import java.util.Scanner;

public class InputView implements Input {

    Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int input(String s) {
        System.out.println(s);
        return scanner.nextInt();
    }
}
