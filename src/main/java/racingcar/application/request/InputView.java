package racingcar.application.request;

public class InputView {
    private final String inputName;
    private final int time;

    public InputView(final String inputName, final int time) {
        this.inputName = inputName;
        this.time = time;
    }

    public String getInputName() {
        return inputName;
    }

    public int getTime() {
        return time;
    }
}
