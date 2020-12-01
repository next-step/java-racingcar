package com.ssabae.nextstep.racingcar.step02;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-02
 */
public interface Validator<T> {
    boolean validate(T t);
}
