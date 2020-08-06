package unittest;

import java.util.Arrays;

public class Calculator {



    public String[] splitInput(String input) throws IllegalArgumentException{
        if(null == input || input.length() == 0) {
            throw new IllegalArgumentException();
        }
        return input.split(" ");
    }

    public int calculate(String[] inputArr) {

        int result = Integer.parseInt(inputArr[0]);
        for(int i=1;i<inputArr.length;i++) {
            result = ArithmeticOperator.getOperator(inputArr[i]).expression.apply(result, Integer.parseInt(inputArr[i+1]));
            i++;
        }

        return result;
    }

}
