package racingcar.control.input;

import racingcar.control.input.validator.NumberValidator;
import racingcar.view.InputView;
import racingcar.view.View;

public class TrialInput extends StandardInput {
    public TrialInput() {
        super();
    }

    public TrialInput(NumberValidator validator) {
        super(validator);
    }

    @Override
    protected View view() {
        return new InputView("시도할 회수는 몇 회 인가요?");
    }
}
