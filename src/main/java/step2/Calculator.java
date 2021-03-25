package step2;

import java.util.List;

public class Calculator {

    public int calculate(List<Integer> nums, List<String> operators) {
        int result = nums.get(0);
        for(int i = 0; i < operators.size(); i++) {
            switch (operators.get(i)) {
                case "+":
                    result = addition(result, nums.get(i+1));
                    break;
                case "-":
                    result = subtraction(result, nums.get(i+1));
                    break;
                case "*":
                    result = multiplication(result, nums.get(i+1));
                    break;
                case "/":
                    result = division(result, nums.get(i+1));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return result;
    }

    public int addition(int num, int result) {
        return result + num;
    }

    public int subtraction(int num, int result) {
        return result - num;
    }

    public int multiplication(int num, int result) {
        return result * num;
    }

    public int division(int result, int num) {
        return result / num;
    }

}


