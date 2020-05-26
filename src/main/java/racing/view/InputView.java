package racing.view;

import racing.util.GameScanner;

public class InputView {

    private InputView(String message) {
        System.out.println(message);
    }

    public static InputView addQuestion(String message) {
        return new InputView(message);
    }

    public int inputNumber() {
        return GameScanner.inputNumber();
    }

    public String inputString() {
        return GameScanner.inputString();
    }
}
