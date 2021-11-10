package step2.model;

public class Calculator {
    private Calculator() {
    }

    public static Integer operator(String str) {
        String[] stringArray = str.split(" ");
        Integer firstIndex = 0;
        Integer result = new Integer(stringArray[firstIndex]);
        for (int i = 1; i < stringArray.length; i += 2) {
            String operator = stringArray[i];
            Integer num1 = new Integer(stringArray[i+1]);
            CalculatorEnum operatorValue = CalculatorEnum.findOperator(operator);
            result = CalculatorEnum.calculator(result, num1, operatorValue);
        }
        return result;
    }
}
