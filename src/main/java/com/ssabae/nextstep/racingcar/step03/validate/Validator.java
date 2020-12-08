package com.ssabae.nextstep.racingcar.step03.validate;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-09
 */
public interface Validator<T> {

    boolean isValid(T t);
}
