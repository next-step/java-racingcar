package edu.nextstep.racingcar.step2;

public enum CalculateCode {

    ADD("+"), SUB("-"), MULTI("*"), DIV("/");

    private final String value;

    CalculateCode(String value) {
        this.value = value;
    }

    public static CalculateCode findByValue(String value) {
        for (CalculateCode calculateCode : values()) {
            if (calculateCode.value.equals(value)) {
                return calculateCode;
            }
        }
        return null;
    }
}
