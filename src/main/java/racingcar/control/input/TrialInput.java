package racingcar.control.input;

import racingcar.control.input.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.View;

public class TrialInput extends StandardInput<Integer> {
    public TrialInput() {
        super();
    }

    public TrialInput(Validator<Integer> validator) {
        super(validator);
    }

    @Override
    protected View view() {
        return new InputView("시도할 회수는 몇 회 인가요?");
    }

    @Override
    protected Integer input() {
        return scanner.nextInt();
    }
}
