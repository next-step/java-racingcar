package step4.mock;

import step3.view.input.AbstractInputView;

public class TestInputView extends AbstractInputView {

    private final String input;

    public TestInputView(String input) {
        this.input = input;
    }

    @Override
    public String read() {
        return input.trim();
    }
}
