package com.ssabae.nextstep.racingcar.step02;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-01
 */
public class StringCalculator implements Calculator {

    private static final String SEPARATOR = " ";

    private final Validator<String[]> validator;

    public StringCalculator(Validator<String[]> validator) {
        this.validator = validator;
    }

    @Override
    public int calculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        String[] split = input.split(SEPARATOR);
        validator.validate(split);
        return calculating(split);
    }

    protected boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    private int calculating(String[] split) {
        int lastValue = 0;
        String lastOperation = "+";
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                int value = Integer.parseInt(split[i]);
                lastValue = operate(lastValue, lastOperation, value);
            } else {
                lastOperation = split[i];
            }
        }
        return lastValue;
    }

    protected int operate(int val1, String operator, int val2) {
        int returnValue = 0;
        switch (operator) {
            case "+":
                returnValue = val1 + val2;
                break;
            case "-":
                returnValue = val1 - val2;
                break;
            case "*":
                returnValue = val1 * val2;
                break;
            case "/":
                returnValue = val1 / val2;
                break;
        }
        return returnValue;
    }
}
