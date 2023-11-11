package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getInputNumber(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }

    public String getInputString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
