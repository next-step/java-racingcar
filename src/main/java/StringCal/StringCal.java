package StringCal;

import org.jetbrains.annotations.NotNull;

public class StringCal {

    public int calculateString(String @NotNull [] str){

        int result = toInt(str[0]);

        for(int i = 0; i < str.length - 2; i += 2){

            result = calculate(result, str[i + 1].charAt(0), toInt(str[i + 2]));

        }
        return result;
    }

    public int toInt(String str){

        return Integer.parseInt(str);
    }

    public String[] seperate(String str){

        return str.split(" ");
    }

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
