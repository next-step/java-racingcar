package calculator;

public class Calculator {
    public int calculation(String input) {
        String[] inputArr = input.split(" ");
        int result = Integer.parseInt(inputArr[0]);
        final int NEXT_CALC_START = 2;
        for(int i = NEXT_CALC_START ; i < inputArr.length ; i += NEXT_CALC_START) {
            result = operate(result,Integer.parseInt(inputArr[i]), inputArr[i-1]);
        }
        return result;
    }

    private int operate(int x, int y, String symbol){
        return Operator.get(symbol).operate(x,y);
    }
}