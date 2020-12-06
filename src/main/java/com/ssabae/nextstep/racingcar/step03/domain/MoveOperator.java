package com.ssabae.nextstep.racingcar.step03.domain;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
public class MoveOperator {

    private final int minValue;
    private final int maxValue;
    private final int movementMinValue;

    public MoveOperator(int minValue, int maxValue, int movementMinValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.movementMinValue = movementMinValue;
    }

    public MoveState operate(int number) {
        if (number < minValue || number > maxValue) {
            String text = String.format("움직일 수 있는 숫자의 허용범위는 %d~%d 까지입니다.", minValue, maxValue);
            throw new IllegalArgumentException(text);
        }
        if (number >= movementMinValue) {
            return MoveState.GO;
        }
        return MoveState.STAY;
    }
}
