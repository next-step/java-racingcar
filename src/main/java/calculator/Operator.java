package calculator;

public enum Operator {
    ADD("+", (a, b) -> a + b),
    SUB("-", (a, b) -> a - b),
    MUL("*", (a, b) -> a * b),
    DIV("/", (a, b) -> a / b);

    private final String operator;
    private final Calculable calculable;

    Operator(String operator, Calculable calculable) {
        this.operator = operator;
        this.calculable = calculable;
    }

    public Calculable getCalculable() {
        return calculable;
    }
}

interface Calculable {

    int calculate(int a, int b);
}


