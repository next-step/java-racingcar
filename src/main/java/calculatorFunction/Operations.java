package calculatorFunction;

public class Operations {

    static double firstOperand, secondOperand;

    public static double add() {
        return firstOperand + secondOperand;
    }

    public static double sub() {
        return firstOperand - secondOperand;
    }

    public static double mul() {
        return firstOperand * secondOperand;
    }

    public static double div() {
        if (secondOperand == 0) {
            throw new IllegalArgumentException("Error: division by zero");
        }
        return firstOperand / secondOperand;
    }
}
