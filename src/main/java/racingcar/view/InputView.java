package racingcar.view;

import java.util.Scanner;

public class InputView {
    private int count;

    public InputView(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        this.count = scanner.nextInt();
    }

    public int getCount() {
       return count;
    }
}
