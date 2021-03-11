package racingcar;

import java.util.Scanner;

public class InputViewCarName<T> extends InputView<T>{

    public InputViewCarName(String text) {
        super(text);
    }

    @Override
    T getInput() {
        super.printText();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return (T) input.split(",");
    }
}
