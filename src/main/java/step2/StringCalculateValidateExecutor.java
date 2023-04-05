package step2;

import step2.model.Input;
import step2.validator.NegativeNumericValidator;
import step2.validator.NonNumericValidator;

import java.util.List;

public class StringCalculateValidateExecutor {


    private static class ValidateExecutorInstanceLazyHolder {

        private static final StringCalculateValidateExecutor INSTANCE = new StringCalculateValidateExecutor();
    }

    public static StringCalculateValidateExecutor getInstance() {

        return ValidateExecutorInstanceLazyHolder.INSTANCE;
    }

    private StringCalculateValidateExecutor() {

    }

    public void executeValidator(Input input) {

        NonNumericValidator.getInstance().validate(input);
        NegativeNumericValidator.getInstance().validate(input);
    }

}
