package Calculator;

import java.util.zip.DataFormatException;

public enum Operator {
    ADD("+") {
        @Override
        Integer calculate(Integer first, Integer second) {
            return first + second;
        }
    }, SUBTRACT("-") {
        @Override
        Integer calculate(Integer first, Integer second) {
            return first - second;
        }
    }, MULTIPLY("*") {
        @Override
        Integer calculate(Integer first, Integer second) {
            return first * second;
        }
    }, DIVIDE("/") {
        @Override
        Integer calculate(Integer first, Integer second) {
            if(second.equals(0)) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return first / second;
        }
    }, NONE("NONE") {
        @Override
        Integer calculate(Integer first, Integer second) throws DataFormatException {
            throw new DataFormatException("올바르지 않은 연산자 입니다.");
        }
    };

    private String code;

    Operator(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static Operator getValue(String code) {
        for(Operator key : Operator.values()) {
            if(key.getCode().equals(code)) {
                return key;
            }
        }
        return NONE;
    }

    abstract Integer calculate(Integer first, Integer second) throws DataFormatException;
}
