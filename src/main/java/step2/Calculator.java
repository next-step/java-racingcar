package step2;

import java.util.ArrayList;

public class Calculator {

    ArrayList<Double> numList;
    ArrayList<String> operationList;

    public Calculator() {}

    public Calculator(ArrayList<Double> numList, ArrayList<String> operationList) {
        this.numList = numList;
        this.operationList = operationList;
    }

    public double addittion(double num1, double num2) {
        return num1 + num2;
    }

    public double subtraction(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplication(double num1, double num2) {
        return num1 * num2;
    }

    public double division(double num1, double num2) {
        return num1 / num2;
    }

    public double getOperationCalcResult(String operationSymbol, double num1, double num2) {
        double calcResult = 0;

        switch (operationSymbol) {
            case "+":
                calcResult = addittion(num1, num2);
                break;
            case "-":
                calcResult = subtraction(num1, num2);
                break;
            case "*":
                calcResult = multiplication(num1, num2);
                break;
            case "/":
                calcResult = division(num1, num2);
                break;
        }
        return calcResult;
    }

    public double resultCalc() {
        double result = 0;
        for (int i = 0; i < operationList.size(); i++) {
            if (i == 0) {
                result = getOperationCalcResult(operationList.get(i), numList.get(i),
                                                numList.get(i + 1));
                continue;
            }
            result = getOperationCalcResult(operationList.get(i), result, numList.get(i + 1));
        }
        return result;
    }

}
