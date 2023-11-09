package racingcar;

import java.util.Scanner;

public class InputView {
    public static int userInput(String msg) {
        ResultView.output(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
