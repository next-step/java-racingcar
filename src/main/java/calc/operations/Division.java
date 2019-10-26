package calc.operations;

public class Division implements Operation {

    @Override
    public double calculate(double op1, double op2) {
        if (op2 == 0)
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return op1 / op2;
    }
}
