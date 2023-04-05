package step2;

import step2.model.Input;
import step2.validator.Validator;

import java.util.Arrays;
import java.util.List;

public class StringCalculateValidateExecutor {

    private List<Validator> validatorList;

    public StringCalculateValidateExecutor(
            Validator... validator
    ) {
        validatorList = Arrays.asList(validator);
    }

    public void executeValidator(Input input) {

        for (Validator validator : validatorList) {
            validator.validate(input);
        }
    }

}
