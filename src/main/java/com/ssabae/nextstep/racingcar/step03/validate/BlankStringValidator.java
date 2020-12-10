package com.ssabae.nextstep.racingcar.step03.validate;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-09
 */
public class BlankStringValidator implements Validator<String> {

    @Override
    public boolean isValid(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
