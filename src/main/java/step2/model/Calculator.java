package step2.model;

public class Calculator {


    public static Integer operator(String str) {
        String[] stringArray = str.split(" ");
        Integer result = new Integer(stringArray[0]);
        for (int i = 1; i < stringArray.length; i += 2) {
            String operator = stringArray[i];
            Integer num1 = new Integer(stringArray[i+1]);
            result = CalculatorEnum.findOperator(result, num1, operator);
        }
        return result;
    }
}
