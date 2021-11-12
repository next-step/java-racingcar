package racingcar.view;

import java.util.Scanner;

public class InputView {
    private int count;

    public InputView(String msg, Scanner scanner) {
        System.out.println(msg);
        this.count = scanner.nextInt();
    }

    public int getCount() {
       return count;
    }
}
