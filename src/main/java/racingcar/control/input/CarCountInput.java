package racingcar.control.input;

import racingcar.control.input.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.View;

public class CarCountInput extends StandardInput<Integer> {
    public CarCountInput() {
        super();
    }

    public CarCountInput(Validator<Integer> validator) {
        super(validator);
    }

    @Override
    protected View view() {
        return new InputView("자동차 대수는 몇 대 인가요?");
    }

    @Override
    protected Integer input() {
        return scanner.nextInt();
    }
}
