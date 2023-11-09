package racingcar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getInputNumber(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}
