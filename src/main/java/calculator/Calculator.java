package calculator;

public class Calculator {
    public int calculation(String input) {
        String[] inputArr = input.split(" ");
        int result = Integer.parseInt(inputArr[0]);
        for(int i = 2 ; i < inputArr.length ; i = i + 2) {
            result = Operator.get(inputArr[i-1]).operate(result, Integer.parseInt(inputArr[i]));
        }
        return result;
    }
}
