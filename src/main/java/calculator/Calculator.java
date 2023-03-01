package calculator;

public class Calculator {

    static long result;

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
        if(num == 0) {
            result = 0;
        }

        result /= num;
    }
}
