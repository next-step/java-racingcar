package racing_car;

public class Calculator {
    int result;
    public int operation(int first , String operator , int second){
        if (operator.equals("+")) result = add(first,second);
        if (operator.equals("-")) result =subtract(first,second);
        if (operator.equals("*")) result =multiply(first, second);
        if (operator.equals("/")) result =divide(first, second);

        return result;
    }

    public int add(int first, int second){
        return first+second;
    }

     public int subtract(int first, int second){
        return first-second;

    }
    public int multiply(int first , int second){
        return first*second;

    }
    public int divide(int  first, int second){
        return first/second;
    }
}
