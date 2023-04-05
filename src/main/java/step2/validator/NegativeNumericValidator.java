package step2.validator;

import step2.common.Separator;
import step2.common.exception.CommonExceptionMessage;

import java.util.List;

public class NegativeNumericValidator implements Validator {

    private static final String NEGATIVE_NUMBER_REGEXP = Separator.NEGATIVE_NUMERIC_SEPARATOR.getRegexp();

    private static class NegativeNumericInstanceLazyHolder {

        private static final NegativeNumericValidator INSTANCE = new NegativeNumericValidator();
    }

    public static NegativeNumericValidator getInstance() {

        return NegativeNumericInstanceLazyHolder.INSTANCE;
    }

    private NegativeNumericValidator(){

    }

    @Override
    public void validate(List<String> inputList) {

        inputList.stream()
                .filter(input -> input.matches(NEGATIVE_NUMBER_REGEXP))
                .findFirst()
                .ifPresent(nonNumeric -> {
                    throw new IllegalArgumentException(CommonExceptionMessage.EXIST_NEGATIVE_NUMBER.getUserGuideMessage());
                });
    }
}
