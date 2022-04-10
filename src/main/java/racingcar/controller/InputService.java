package racingcar.controller;

import commons.Constant;
import exceptions.InputValueException;

public class InputService {

    public int convertInputValue(String inputValue) {
        return Integer.parseInt(validationInputValue(inputValue));
    }

    private String validationInputValue(String inputValue) throws InputValueException {
        if (!inputValue.matches(Constant.NUMERIC_REGEX)) {
            throw new RuntimeException(Constant.NON_NUMERIC_ERR_MSG);
        }

        if (!inputValue.matches(Constant.POSITIVE_INTEGER_REGEX)) {
            throw new RuntimeException(Constant.ZERO_OR_NEGATIVE_NUMERIC_ERR_MSG);
        }

        return inputValue;
    }
}
