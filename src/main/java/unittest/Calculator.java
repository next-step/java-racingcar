package unittest;

public class Calculator {

    public int sumText(String inputText) {
        String[] inputArr = splitInput(inputText);
        return calculate(inputArr);
    }


    public String[] splitInput(String input) throws IllegalArgumentException{
        if(null == input || input.length() == 0) {
            throw new IllegalArgumentException();
        }
        return input.split(" ");
    }

    public int calculate(String[] inputArr) {
        ArithmeticOperator operator = new ArithmeticOperator();
        int result = 0;
        result = Integer.parseInt(inputArr[0]);
        for(int i=1;i<inputArr.length;i++) {
            if(operator.isArithmeticiOperator(inputArr[i])) {
                result = operator.calculateAAndB(result, Integer.parseInt(inputArr[i + 1]), inputArr[i]);
                i++;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

}
