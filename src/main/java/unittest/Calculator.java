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
        int result = 0;

        return result;
    }

}
