package racingcar.control.input.validator;

import racingcar.validator.NameLengthValidator;
import racingcar.validator.Validator;

import java.util.List;

public class NamesValidator implements Validator<List<String>> {
    @Override
    public void verify(List<String> name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Car names cannot be null or empty");
        }
        Validator<String> lengthValidator = new NameLengthValidator();
        name.forEach(lengthValidator::verify);
    }
}
