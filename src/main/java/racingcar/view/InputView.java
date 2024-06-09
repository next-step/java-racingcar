package racingcar.view;

import java.util.Scanner;

public class InputView {
    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public int inputInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
