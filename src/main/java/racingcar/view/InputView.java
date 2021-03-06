package racingcar.view;

import java.util.Scanner;

public class InputView implements ConsoleView {
    public Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }
    @Override
    public void print(String str) {
        System.out.println(str);
    }
}
