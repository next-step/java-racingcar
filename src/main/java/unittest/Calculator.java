package unittest;

import java.util.Arrays;

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
        int result = 0;
        //Arrays.stream(inputArr).forEach(ArithmeticOperator.getOperator());
        for(int i=1;i<inputArr.length;i++) {

        }
        return result;
    }

}
