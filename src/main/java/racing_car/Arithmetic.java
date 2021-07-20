package racing_car;

public class Arithmetic {
    public int operation(int first, String operation, int second){
        if (operation.equals("+")) return add(first,second);
        if (operation.equals("-")) return subtract(first,second);
        if (operation.equals("*")) return multiply(first,second);
        if (operation.equals("/")) return divide(first,second);

        return 0;
    }

    static int add(int first, int second){
        return first+second;
    }

    static int subtract(int first, int second){
        return first-second;

    }
    static int multiply(int first , int second){
        return first*second;

    }
    static int divide(int  first, int second){
        return first/second;
    }
}
