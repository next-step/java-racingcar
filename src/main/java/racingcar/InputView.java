package racingcar;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static Integer readInt(String displayText) {
        System.out.println(displayText);
        return scanner.nextInt();
    }

}
