package domain.operation;

import domain.Operand;

import static domain.Operand.ZERO;

class BasicComputationStrategy {

    private BasicComputationStrategy() {
    }

    static Operand plus(Operand input, Operand operand) {
        return new Operand(input.getValue() + operand.getValue());
    }

    static Operand subtract(Operand a, Operand b) {
        return new Operand(a.getValue() - b.getValue());
    }

    static Operand multiply(Operand a, Operand b) {
        return new Operand(a.getValue() * b.getValue());
    }

    static Operand divide(Operand input, Operand operand) {
        if (operand.equals(ZERO)) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return new Operand(input.getValue() / operand.getValue());
    }
}
