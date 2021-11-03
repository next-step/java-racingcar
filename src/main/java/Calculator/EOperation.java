package Calculator;

import java.util.zip.DataFormatException;

public enum EOperation {
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
            return first / second;
        }
    }, NONE("NONE") {
        @Override
        Integer calculate(Integer first, Integer second) throws DataFormatException {
            throw new DataFormatException("올바르지 않은 연산자 입니다.");
        }
    };

    private String code;

    EOperation(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static EOperation getValue(String code) {
        for(EOperation key : EOperation.values()) {
            if(key.getCode().equals(code)) {
                return key;
            }
        }
        return NONE;
    }

    abstract Integer calculate(Integer first, Integer second) throws DataFormatException;
}
