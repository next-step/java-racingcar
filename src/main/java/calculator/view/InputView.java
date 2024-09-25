package calculator.view;

public class InputView {

    private final String input;

    public InputView(String input) {
        this.input = input;
    }

    public void printInput() {
        System.out.println("입력값 = " + input);
    }

    public String input() {
        return input;
    }
}
