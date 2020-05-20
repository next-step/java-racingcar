package racing;

public class InputView {

    InputView(String message) {
        System.out.println(message);
    }

    public static InputView addQuestion(String message) {
        return new InputView(message);
    }

    public int input() {
        return GameScanner.input();
    }
}
