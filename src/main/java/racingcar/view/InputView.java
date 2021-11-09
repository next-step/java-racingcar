package racingcar.view;

import java.util.Scanner;

public class InputView {
    public int getCount(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
