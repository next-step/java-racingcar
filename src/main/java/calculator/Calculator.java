package calculator;

public class Calculator {

    public static int plus(int left, int right) {
        return left + right;
    }

    public static int minus(int left, int right) {
        return left - right;
    }

    public static int multiply(int left, int right) {
        return left * right;
    }

    public static int division(int left, int right) {
<<<<<<< HEAD
        if (right == 0) {
            throw new IllegalArgumentException("Can't divide by 0");
        }
=======
        if(right == 0) throw new IllegalArgumentException("Can't divide by 0");
>>>>>>> f785082b19fdde874a3674d0a70d79f8a94abb98
        return left / right;
    }
}
