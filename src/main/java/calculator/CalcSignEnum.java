package calculator;

import java.util.Arrays;

public enum CalcSignEnum {

    ADD("+") {
        @Override
        int calc(int a, int b) {
            return a + b;
        }
    }, MINUS("-") {
        @Override
        int calc(int a, int b) {
            return a - b;
        }
    }, MULTI("*") {
        @Override
        int calc(int a, int b) {
            return a * b;
        }
    }, DIVIDE("/") {
        @Override
        int calc(int a, int b) {
            return a / b;
        }
    };

    private final String sign;

    CalcSignEnum(String sign) {
        this.sign = sign;
    }

    static CalcSignEnum find(String sign) {
        return Arrays.stream(values())
            .filter(signEnum -> signEnum.sign.equals(sign))
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
    }

    abstract int calc(int a, int b);

}
