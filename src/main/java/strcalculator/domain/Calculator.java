package strcalculator.domain;

import java.util.List;

public class Calculator {
    private List<String> inputStr;
    private String[] numberList;
    private String[] operandList;
    public Calculator() {
    }

    public Calculator(List<String> inputStr) {
        this.inputStr=inputStr;
    }

    public Calculator(String[] numberList,String[]operandList) {
        this.numberList=numberList;
        this.operandList=operandList;
    }

    public void calculate() {
        int total = Integer.valueOf(numberList[0]);
        for (int i = 1; i < operandList.length; i++) {
            String operator = operandList[i];
            if (operator.equals("+")) {
                total = add(total, Integer.valueOf(numberList[i]));
                continue;
            }
            if (operator.equals("-")) {
                total = subtract(total, Integer.valueOf(numberList[i]));
                continue;
            }
            if (operator.equals("*")) {
                total = multiply(total, Integer.valueOf(numberList[i]));
                continue;
            }
            if (operator.equals("/")) {
                total = divide(total, Integer.valueOf(numberList[i+1]));
                continue;
            }
        }
        System.out.println(total);
    }

    public int add(int number1, int number2) {
        return number1 + number2;
    }

    public int subtract(int number1, int number2) {
        return number1 - number2;
    }

    public int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public int divide(int number1, int number2) {
        return number1 / number2;
    }
}
