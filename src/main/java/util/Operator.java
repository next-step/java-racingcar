package util;

public class Operator {
    public static double operateArithmetic(double res, String operator, double temp){
        switch (operator) {
            case "+":
                return plus(res,temp);
            case "-":
                return minus(res,temp);
            case "*":
                return multiply(res,temp);
            case "/":
                return divide(res,temp);
            default:
                throw new IllegalArgumentException("");
        }
    }


    public static double plus(double res, double temp){
        return res+temp;
    }
    public static double minus(double res, double temp){
        return res+temp;
    }
    public static double multiply(double res, double temp){
        return res+temp;
    }
    public static double divide(double res, double temp){
        return res+temp;
    }
}
