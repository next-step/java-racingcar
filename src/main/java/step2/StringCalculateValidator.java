package step2;

import step2.common.Separator;
import step2.common.exception.CommonExceptionMessage;

import java.util.List;
import java.util.Optional;

public class StringCalculateValidator {

    private static final String NON_NUMERIC_REGEXP = "[^0-9]";
    private static final String NEGATIVE_NUMBER_REGEXP = Separator.NEGATIVE_NUMERIC_SEPARATOR.getRegexp();

    private static class ValidatorInstanceLazyHolder {
        private static final StringCalculateValidator INSTANCE = new StringCalculateValidator();
    }

    public static StringCalculateValidator getInstance() {
        return ValidatorInstanceLazyHolder.INSTANCE;
    }

    public void executeValidator(List<String> inputList) {
        validateNegativeNumeric(inputList);
        validateNonNumeric(inputList);
    }

    private Optional<String> findIncorrectInput(List<String> inputList, String regexp) {
        return inputList.stream()
                .filter(input -> input.matches(regexp))
                .findFirst();
    }

    private void validateNonNumeric(List<String> inputList) {
        findIncorrectInput(inputList, NON_NUMERIC_REGEXP).ifPresent(nonNumeric -> {
            throw new IllegalArgumentException(CommonExceptionMessage.EXIST_NON_NUMERIC.getUserGuideMessage());
        });
    }

    private void validateNegativeNumeric(List<String> inputList) {
        findIncorrectInput(inputList, NEGATIVE_NUMBER_REGEXP).ifPresent(nonNumeric -> {
            throw new IllegalArgumentException(CommonExceptionMessage.EXIST_NEGATIVE_NUMBER.getUserGuideMessage());
        });
    }
}
