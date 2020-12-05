package com.ssabae.nextstep.racingcar.step02;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-02
 */
public class StringCalculateValidator implements Validator<String[]> {

    public static final String INVALID_PAIR_MESSAGE = "연산자와 숫자의 조합이 올바르지 않습니다.";
    public static final String INVALID_OPERATION_MESSAGE = "사칙연산 기호가 아닌 문자열은 포함 할 수 없습니다.";

    @Override
    public boolean validate(String[] strings) {
        if (strings.length % 2 == 0) {
            throw new IllegalArgumentException(INVALID_PAIR_MESSAGE);
        }
        for (int i = 1; i < strings.length; i += 2) {
            isOperator(strings[i]);
        }
        return true;
    }

    private void isOperator(String str) {
        if (!Operator.isOperator(str)) {
            throw new IllegalArgumentException(INVALID_OPERATION_MESSAGE);
        }
    }
}
