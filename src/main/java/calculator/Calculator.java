package calculator;


public class Calculator {

    public int calculate(String[] data) {
        int numberOne = Integer.parseInt(data[0]);
        for(int i = 1; i< data.length; i = i + 2) {
            String operator = data[i];
            int numberTwo = Integer.parseInt(data[i+1]);
            numberOne = detailCalculate(numberOne,operator,numberTwo);
        }
        return numberOne;
    }

    private int detailCalculate(int numberOne, String operator, int numberTwo) {
        int answer = 0;
        switch(operator) {
            case "+" : answer = plusCalculate(numberOne,numberTwo); break;
            case "-" : answer = minusCalculate(numberOne,numberTwo); break;
            case "*" : answer = multiplyCalculate(numberOne,numberTwo); break;
            case "/" : answer = devideCalculate(numberOne,numberTwo); break;
        }

        return answer;
    }

    private int devideCalculate(int numberOne, int numberTwo) {
        return numberOne / numberTwo;
    }

    private int multiplyCalculate(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    private int minusCalculate(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    private int plusCalculate(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

}
