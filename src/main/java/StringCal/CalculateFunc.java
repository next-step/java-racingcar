package StringCal;

public class CalculateFunc {

    public int calculate(int x, char oper, int y){

        switch (oper) {
            case '+':
                return add(x, y);
            case '-':
                return subtract(x, y);
            case '*':
                return multiply(x, y);
            case '/':
                return divide(x, y);
            default : throw new IllegalArgumentException();
        }

    }

    public int subtract(int x, int y)
    {
        return x-y;
    }


    public int add(int x, int y)
    {
        return x+y;
    }


    public int multiply(int x, int y)
    {
        return x*y;
    }

    public int divide(int x, int y)
    {
        try{

            return x / y;

        } catch (ArithmeticException e){

            throw new IllegalArgumentException("0으로 나눌 수 없다.");

        }
    }
}
