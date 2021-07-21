package edu.nextstep.racingcar.step2;

import java.util.Arrays;

public enum CalculateCode {

    ADD("+"), SUB("-"), MULTI("*"), DIV("/");

    private final String value;

    CalculateCode(String value) {
        this.value = value;
    }

    public static CalculateCode findByValue(String value) {
        return Arrays.stream(values())
                .filter(codeValue -> codeValue.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new BusinessException(BusinessError.INVALID_VALUE));
    }
}
