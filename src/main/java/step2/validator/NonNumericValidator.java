package step2.validator;

import step2.common.exception.CommonExceptionMessage;

import java.util.List;

public class NonNumericValidator implements Validator {

    private static final String NON_NUMERIC_REGEXP = "[^0-9]+";

    private static class NonNumericValidatorInstanceLazyHolder {

        private static final NonNumericValidator INSTANCE = new NonNumericValidator();
    }

    public static NonNumericValidator getInstance() {

        return NonNumericValidatorInstanceLazyHolder.INSTANCE;
    }

    private NonNumericValidator() {

    }

    @Override
    public void validate(List<String> inputList) {

        inputList.stream()
                .filter(input -> input.matches(NON_NUMERIC_REGEXP))
                .findFirst()
                .ifPresent(nonNumeric -> {
                    throw new IllegalArgumentException(CommonExceptionMessage.EXIST_NON_NUMERIC.getUserGuideMessage());
                });
    }
}
