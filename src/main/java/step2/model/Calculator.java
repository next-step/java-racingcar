package step2.model;

public class Calculator {

    private Calculator() {
    }

    public static Integer calculateAll(String str) {
        String[] stringArray = str.split(" ");
        Integer firstIndex = 0;
        Integer result = new Integer(stringArray[firstIndex]);
        for (int i = 1; i < stringArray.length; i += 2) {
            String operator = stringArray[i];
            Integer num1 = new Integer(stringArray[i+1]);
            Operator operatorValue = Operator.findOperator(operator);
            result = Operator.calculator(result, num1, operatorValue);
        }
        return result;
    }
}
