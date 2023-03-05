package calculator;

public class Calculator {

    long result;

    void addition(long num) {
        result += num;
    }

    void subtraction(long num) {
        result -= num;
    }

    void multiplication(long num) {
        result *= num;
    }

    void division(long num) {
        if(num == 0) throw new IllegalArgumentException();

        result /= num;
    }
}
