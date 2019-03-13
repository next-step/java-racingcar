package calculator.domain;

public enum CalculatorOperator {
    ADD("+", (v1, v2) -> v1 + v2),
    ADD2("p", (v1, v2) -> v1 + v2),
    SUBTRACT("-", (v1, v2) -> v1 - v2),
    MULTIPLICATION("*", (v1, v2) -> v1 * v2),
    DIVISION("/", (v1, v2) -> v1 / v2);

    private String operator;

    private CalculateFunction expression;

    CalculatorOperator(String operator, CalculateFunction expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public Integer calculate(Integer v1, Integer v2) {
        return expression.calculate(v1, v2);
    }

    public static CalculatorOperator getEnumNameByString(String text){
        for(CalculatorOperator operator : CalculatorOperator.values()){
            if(operator.operator.equals(text))
                return operator;
        }
        return null;
    }
}
