package racingcar;

import java.util.Scanner;

public class InputView {
    public int userInput(String msg) {
        System.out.println(msg);
        return new Scanner(System.in).nextInt();
    }
}
