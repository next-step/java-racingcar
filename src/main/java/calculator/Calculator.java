package calculator;

public class Calculator {
    String formula = "";
    String[] operationSymbols = null;
    double resultVal = 0;

    public Calculator(String formula, String[] operationSymbols) {
        this.formula = formula;
        this.operationSymbols = operationSymbols;
    }

    public double calculate(String[] result) {
        double intputVal = 0;


        for (int i = 0; i < result.length; i++) {

            if (isNullOrEmpty(result[i])) {
                throw new IllegalArgumentException("빈값을 입력하셨습니다.");
            }

            //최초 0번째
            if(i == 0) {
                resultVal = Double.parseDouble(result[0]);
            }

            if ( (i % 2 == 0) && (i+2 < result.length) ) {
                intputVal = Double.valueOf(result[i+2]);
            }

            if (i % 2 == 1) {
                operatorCalcualte(result[i],intputVal);
            }

        }

        return resultVal;
    }

    public void operatorCalcualte(String operator, double intputVal) {

        if (!operatorCheck(operator)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

        //덧셈
        if (operator.equals(operationSymbols[0])) {
            adddition(intputVal);
        }
        //뺄셈
        if (operator.equals(operationSymbols[1])) {
            subtraction(intputVal);
        }
        //곱셈
        if (operator.equals(operationSymbols[2])) {
            multiplication(intputVal);
        }
        //나눗셈
        if (operator.equals(operationSymbols[3])) {
            division(intputVal);
        }

    }

    public double adddition(double a) {
        resultVal += a;
        return resultVal;
    }

    public double subtraction(double a) {
        resultVal -= a;
        return resultVal;
    }

    public double multiplication(double a) {
        resultVal *= a;
        return resultVal;
    }

    public double division(double a) {
        if (a == 0) {
            throw new ArithmeticException("0으로 나눌수 없습니다.");
        }
        resultVal /= a;
        return resultVal;
    }


    public boolean isNullOrEmpty(String param) {
        if (param == null || param.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean operatorCheck(String operator) {

        boolean isOperator = false;
        for (String symbol : operationSymbols) {
            if (symbol.equals(operator)) {
                isOperator = true;
                break;
            }
        }
        return isOperator;
    }
}
