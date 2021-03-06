package racing.view;

public class IntegerInputView extends InteractiveInputView<Integer> {

    public IntegerInputView(String message) {
        super(message);
    }

    @Override
    protected Integer parse(String s) {
        return Integer.parseInt(s);
    }
}
