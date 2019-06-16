package step1;

public class Calculator {

    static int add(int a, int b){
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiple(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return a / b;
    }

    public int calculate(String operatorType, int leftValue, String rightValueInString) {

        int rightValue = Integer.parseInt(rightValueInString);

        if("+".equals(operatorType)) return add(leftValue, rightValue);
        if("-".equals(operatorType)) return subtract(leftValue, rightValue);
        if("*".equals(operatorType)) return multiple(leftValue, rightValue);
        if("/".equals(operatorType)) return divide(leftValue, rightValue);

        return -1;
    }

}
