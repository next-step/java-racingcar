package calculator;

public class Calculator {
    public int calculation(String input) {
        String[] inputArr = input.split(" ");
        int result = Integer.parseInt(inputArr[0]);
        for(int i = 2 ; i < inputArr.length ; i += 2) {
            result = operate(result,Integer.parseInt(inputArr[i]), inputArr[i-1]);
        }
        return result;
    }

    private int operate(int x, int y, String symbol){
        return Operator.get(symbol).operate(x,y);
    }
}