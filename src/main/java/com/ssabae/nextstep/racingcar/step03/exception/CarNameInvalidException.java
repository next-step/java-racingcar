package com.ssabae.nextstep.racingcar.step03.exception;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-09
 */
public class CarNameInvalidException extends RuntimeException {

    public CarNameInvalidException() {
        super("자동차 이름은 비어있거나 5자를 초과할 수 없습니다.");
    }
}
