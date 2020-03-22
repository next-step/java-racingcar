package calculator;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {
    String formula;
    String[] resultArr;
    Calculator calculator;
    double resultValue = 0;

    enum OperatorType {
        ADDTION("+"),
        SUBTRACTION("-"),
        MULTIPLICATION("*"),
        DIVISION("/");

        String value;

        private OperatorType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        private static Map<String, OperatorType> operatorMap = new HashMap<>();

        public static OperatorType getOperator(String operator) {
            return operatorMap.get(operator);
        }

        static {
            operatorMap.put("+", OperatorType.ADDTION);
            operatorMap.put("-", OperatorType.SUBTRACTION);
            operatorMap.put("*", OperatorType.MULTIPLICATION);
            operatorMap.put("/", OperatorType.DIVISION);
        }

    }

    public StringCalculator() {
        calculator = new Calculator();
    }


    public double calculate(String formula) {
        if (isNullOrEmpty(formula)) {
            throw new IllegalArgumentException("빈값을 입력하셨습니다.");
        }
        resultArr = formula.split(" ");
        resultValue = Double.parseDouble(resultArr[0]);

        for (int i = 2; i < resultArr.length; i += 2) {
            resultValue = operatorCalcualte(resultArr[i - 1], resultValue, Double.parseDouble(resultArr[i]));
        }

        return resultValue;
    }

    public double operatorCalcualte(String symbol, double a, double b) {

        OperatorType operatorType = OperatorType.getOperator(symbol);

        switch (operatorType) {
            case ADDTION:
                return calculator.adddition(a, b);

            case SUBTRACTION:
                return calculator.subtraction(a, b);

            case MULTIPLICATION:
                return calculator.multiplication(a, b);

            case DIVISION:
                return calculator.division(a, b);

            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

    }

    public boolean isNullOrEmpty(String param) {
        if (param == null || param.isEmpty()) {
            return true;
        }
        return false;
    }


}
