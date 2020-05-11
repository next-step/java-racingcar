package calculator;

public class Operator {
    public Operator(){

    }

    public static int add(int left, int right){
        return left + right;
    }

    public static int subtract(int left, int right){
        return left - right;
    }

    public static int multiply(int left, int right){
        return left * right;
    }

    public static int divide(int left, int right){
        //0으로 나눌때 예외처리 해야됨
        return left / right;
    }

}
