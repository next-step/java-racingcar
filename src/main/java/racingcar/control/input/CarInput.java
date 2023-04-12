package racingcar.control.input;

import racingcar.control.input.validator.NumberValidator;
import racingcar.view.InputView;
import racingcar.view.View;

public class CarInput extends StandardInput {
    public CarInput() {
        super();
    }

    public CarInput(NumberValidator validator) {
        super(validator);
    }

    @Override
    protected View view() {
        return new InputView("자동차 대수는 몇 대 인가요?");
    }
}
