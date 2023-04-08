package racingcar.view;

public class InputView implements View {

    private final String message;

    public InputView(String message) {
        this.message = message;
    }

    @Override
    public void render() {
        System.out.println(this.message);
    }
}
