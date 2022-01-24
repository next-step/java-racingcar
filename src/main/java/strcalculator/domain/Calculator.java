package strcalculator.domain;

public class Calculator {

    private String[] numberList;
    private String[] operandList;
    private int leftNumber = 0;
    private int rightNumber = 0;

    public Calculator(String[] numberList, String[] operandList) {
        this.numberList = numberList;
        this.operandList = operandList;
    }

    public void calculate() {
        leftNumber = Integer.valueOf(numberList[0]);
        for (int i = 1; i < operandList.length; i++) {
            rightNumber = Integer.valueOf(numberList[i]);
            String operator = operandList[i];
            if (operator.equals("+")) {
                leftNumber = add();
                continue;
            }
            if (operator.equals("-")) {
                leftNumber = subtract();
                continue;
            }
            if (operator.equals("*")) {
                leftNumber = multiply();
                continue;
            }
            if (operator.equals("/")) {
                leftNumber = divide();
                continue;
            }
        }
        System.out.println(leftNumber);
    }

    private int add() {
        return leftNumber + rightNumber;
    }

    private int subtract() {
        return leftNumber - rightNumber;
    }

    private int multiply() {
        return leftNumber * rightNumber;
    }

    private int divide() {
        return leftNumber / rightNumber;
    }
}
