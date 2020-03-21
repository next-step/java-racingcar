package calculator;

public class StringCalculator {
    String formula;
    String[] resultArr;
    Calculator calculator;
    double resultValue = 0;

    public StringCalculator() {
        calculator = new Calculator();
    }


    public double calculate(String formula) {
        if(isNullOrEmpty(formula)) {
            throw new IllegalArgumentException("빈값을 입력하셨습니다.");
        }
        resultArr   = formula.split(" ");
        resultValue = Double.parseDouble(resultArr[0]);

        for(int i = 2; i < resultArr.length; i+=2) {
            resultValue = operatorCalcualte(resultArr[i-1] , resultValue, Double.parseDouble(resultArr[i]));
        }

        return resultValue;
    }

    public double operatorCalcualte(String symbol, double a, double b) {
        if("+".equals(symbol)) {
            return calculator.adddition(a,b);
        }

        if("-".equals(symbol)) {
            return calculator.subtraction(a,b);
        }

        if("*".equals(symbol)) {
            return calculator.multiplication(a,b);
        }

        if("/".equals(symbol)) {
            return calculator.division(a,b);
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    public boolean isNullOrEmpty(String param) {
        if (param == null || param.isEmpty()) {
            return true;
        }
        return false;
    }


}
