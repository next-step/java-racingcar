package stringcalculator.arithmeticcomponent;

/**
 * 연산에 필요한 피연산자
 */
class ArithmeticOperand {
    private final int number;

    ArithmeticOperand(int number) {
        this.number = number;
    }

    int number() {
        return number;
    }
}
