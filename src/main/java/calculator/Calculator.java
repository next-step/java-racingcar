package calculator;


public class Calculator {
//left = Operator.find(operator).calculate(left, right);
    public int calculate(String[] data) {
        int numberOne = Integer.parseInt(data[0]);
        for(int i = 1; i< data.length; i = i + 2) {
            String operator = data[i];
            int numberTwo = Integer.parseInt(data[i+1]);
            numberOne = Operator.findOperation(operator).calculate(numberOne,numberTwo);
        }
        return numberOne;
    }

}
