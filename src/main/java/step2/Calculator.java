package step2;

public class Calculator {

    public int addition (int num1, int num2) {
        return num1 + num2;
    }

    public int subtraction (int num1, int num2) {
        return num1 - num2;
    }

    public int multiplication (int num1, int num2) {
        return num1 * num2;
    }

    public int division (int num1, int num2) {
        if (num2 <= 0) {
            throw new ArithmeticException("0으로는 나눌수 없습니다");
        }
        return num1 / num2;
    }
    public void vaildate(String input){
        if(input.trim().isEmpty() || input == null){
            throw new IllegalArgumentException("에러");
        }
    }
}
