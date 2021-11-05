package step2.model;

public class Calculator {

    public static Integer operator(String str) {
        String[] StringArray = str.split(" ");
        Integer result = new Integer(StringArray[0]);
        for (int i = 1; i < StringArray.length; i += 2) {
            String operator = StringArray[i];
            Integer num1 = new Integer(StringArray[i+1]);
            result = CalculatorEnum.findOperator(result, num1, operator);
        }
        return result;
    }
}
