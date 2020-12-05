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
        int lastValue = Integer.parseInt(split[0]);
        for (int i = 2; i < split.length; i += 2) {
            int value = Integer.parseInt(split[i]);
            Operator operator = Operator.find(split[i - 1]);
            lastValue = operator.operation(lastValue, value);
        }
        return lastValue;
    }
}
