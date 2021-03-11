package racingcar;

public abstract class InputView<T> {
    String text;

    public InputView(String text) {
        this.text = text;
    }

    abstract T getInput();

    protected void printText() {
        System.out.println(this.text);
    }
}
