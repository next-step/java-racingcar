package stringCalculator;

import java.util.List;

public class Calculator {

    public int calculateByOperator (List<String> userInput){
        int result = Integer.parseInt(userInput.get(0));

        for (int i=1; i<userInput.size()-1; i+=2){
            int nextNumber = Integer.parseInt(userInput.get(i+1));

            switch(userInput.get(i)) {
                case "+":
                    result = sum(result, nextNumber);
                    continue;
                case "-":
                    result = subtract(result, nextNumber);
                    continue;
                case "*":
                    result = multiply(result, nextNumber);
                    continue;
                case "/":
                    result = divide(result, nextNumber);
                    continue;
            }
        }
        return result;
    }
    private int sum (int a, int b){
        return a +b;
    }
    private int subtract(int a, int b){
        return a-b;
    }
    private int multiply(int a, int b){
        return a*b;
    }
    private int divide(int a, int b){
        return a/b;
    }
}
