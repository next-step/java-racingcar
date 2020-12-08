package com.ssabae.nextstep.racingcar.step03.validate;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-09
 */
public class StringLengthValidator implements Validator<String> {

    private final int minLength;
    private final int maxLength;

    public StringLengthValidator(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        return str.length() >= minLength && str.length() <= maxLength;
    }
}
