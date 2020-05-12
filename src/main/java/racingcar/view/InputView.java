package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int input(String content) {
        System.out.println(content);
        return SCANNER.nextInt();
    }
}
