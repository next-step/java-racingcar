package step3.util;

import java.util.Scanner;

public class InputView {

    private final Scanner SCANNER = new Scanner(System.in);

    public int getCount(String message) {
        System.out.println(message);

        return SCANNER.nextInt();
    }

}
