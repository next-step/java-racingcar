package racingcar.control.input;

import racingcar.control.input.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.View;

import java.util.List;

public class CarNamesInput extends StandardInput<List<String>> {
    private final static String NAME_DELIMITER = ",";

    public CarNamesInput() {
        super();
    }

    public CarNamesInput(Validator<List<String>> validator) {
        super(validator);
    }

    @Override
    protected View view() {
        return new InputView("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @Override
    protected List<String> input() {
        String raw = scanner.nextLine();
        String[] names = raw.split(NAME_DELIMITER);
        return List.of(names);
    }
}
