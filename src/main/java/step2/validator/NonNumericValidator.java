package step2.validator;

import step2.common.exception.CommonExceptionMessage;
import step2.model.Input;

public class NonNumericValidator implements Validator {

    private static final String NON_NUMERIC_REGEXP = "[^0-9]+";

    @Override
    public void validate(Input input) {

        input.getInputList()
                .stream()
                .filter(verifier -> verifier.matches(NON_NUMERIC_REGEXP))
                .findFirst()
                .ifPresent(nonNumeric -> {
                    throw new IllegalArgumentException(CommonExceptionMessage.EXIST_NON_NUMERIC.getUserGuideMessage());
                });
    }
}
