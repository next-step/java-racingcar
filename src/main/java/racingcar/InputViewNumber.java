package racingcar;

import java.util.Scanner;

public class InputViewNumber<T> extends InputView<T> {

    public InputViewNumber(String text) {
        super(text);
    }

    @Override
    T getInput() {
        super.printText();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return (T) Integer.valueOf(input);
    }

}
